import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuessingGameAgent {
    private static final Object lock = new Object(); // 锁对象

    public static void premain(String agentArgs, Instrumentation inst) {
        try {
            // 加载 GuessingGame 类
            Class<?> clazz = Class.forName("GuessingGame");

            // 获取 secretNumber 字段
            Field secretNumberField = clazz.getDeclaredField("secretNumber");
            secretNumberField.setAccessible(true); // 绕过 private 访问限制

            // 创建线程池模拟多线程环境
            ExecutorService executor = Executors.newFixedThreadPool(10);

            for (int i = 0; i < 5; i++) { // 启动多个线程
                executor.submit(() -> {
                    synchronized (lock) { // 确保线程安全
                        try {
                            // 获取 secretNumber 的值
                            Object secretNumberValue = secretNumberField.get(null);

                            // 输出 secretNumber 的当前值
                            System.out.println(
                                    Thread.currentThread().getName() + " - Current secretNumber: " + secretNumberValue);

                            // 输出 secretNumber 的地址 (内存标识)
                            if (secretNumberValue != null) {
                                System.out.println(Thread.currentThread().getName() + " - Address (identity hash): "
                                        + System.identityHashCode(secretNumberValue));
                            } else {
                                System.out.println(Thread.currentThread().getName()
                                        + " - Address: null (secretNumber is not initialized)");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            executor.shutdown(); // 关闭线程池

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

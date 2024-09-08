import java.util.LinkedList;
import java.util.Queue;

class assignment3_1_15 {
    public static class MyStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue1.offer(x);
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public int pop() {
            if (empty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return queue2.poll();
        }

        public int top() {
            if (empty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return queue2.peek();
        }

        public boolean empty() {
            return queue2.isEmpty();
        }

    }

    public static void main(String[] args) {
        String[] operations = { "MyStack", "push", "push", "top", "pop", "empty" };
        Object[][] values = { {}, { 1 }, { 2 }, {}, {}, {} };
        MyStack myStack = null;
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MyStack":
                    myStack = new MyStack();
                    System.out.println("null");
                    break;
                case "push":
                    myStack.push((Integer) values[i][0]);
                    System.out.println("null");
                    break;
                case "top":
                    System.out.println(myStack.top());
                    break;
                case "pop":
                    System.out.println(myStack.pop());
                    break;
                case "empty":
                    System.out.println(myStack.empty());
                    break;
            }
        }
    }
}


// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private static int secretNumber;

    public GuessingGame() {
    }

    public static void main(String[] var0) {
        secretNumber = (new Random()).nextInt(101);
        System.out.println("Guess a number (0-100): ");
        Scanner var1 = new Scanner(System.in);
        int var2 = var1.nextInt();
        String var3 = var2 == secretNumber ? "Correct!" : "Wrong!";
        System.out.println(var3 + " The answer is: " + secretNumber);
        var1.close();
    }
}

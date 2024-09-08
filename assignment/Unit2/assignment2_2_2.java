public class assignment2_2_2 {
    public static void main(String[] args) {

        abstract class BankAccount {
            abstract public void deposit();

            abstract public void withdraw();
        }
        class SavingAccount extends BankAccount {
            @Override
            public void deposit() {
                System.out.println("deposit");
            }

            @Override
            public void withdraw() {
                System.out.println("withdraw");
            }
        }

        class CurrentAccount extends BankAccount {
            @Override
            public void deposit() {
                System.out.println("deposit");
            }

            @Override
            public void withdraw() {
                System.out.println("withdraw");
            }
        }
    }
}

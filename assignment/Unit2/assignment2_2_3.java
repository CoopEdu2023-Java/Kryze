public class assignment2_2_3 {
    public static void main(String[] args) {
        abstract class Employee {
            public int salary;

            abstract public void displayInfo();

            abstract public void calculateSalary(int time);
        }

        class Manager extends Employee {
            @Override
            public void displayInfo() {
                System.out.println(this.salary);
            }

            @Override
            public void calculateSalary(int time) {
                System.out.println(this.salary * time);
            }
        }

        class Programmer extends Employee {
            @Override
            public void displayInfo() {
                System.out.println(this.salary);
            }

            @Override
            public void calculateSalary(int time) {
                System.out.println(this.salary * time);
            }
        }
    }
}

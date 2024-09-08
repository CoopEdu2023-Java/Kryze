public class assignment3 {
    public static void main(String[] args) {
        class Employee {
            private Integer salary;
            private String id, name;

            public Employee() {

            }

            public Employee(Integer salary, String name, String id) {
                this.salary = salary;
                this.name = name;
                this.id = id;
            }

            public String getter() {
                return name + " id: " + id + "has a salary of " + salary;
            }
        }
        Employee emp = new Employee(114, "xianxian", "asd");
        System.out.print(emp.getter());
    }
}

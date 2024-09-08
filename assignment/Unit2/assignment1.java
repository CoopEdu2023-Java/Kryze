class assignment1 {
    public static void main(String[] args) {
        class Person {
            private Integer age;
            private String country, name;

            public Person() {
            }

            public Person(String name, String country, Integer age) {
                this.age = age;
                this.name = name;
                this.country = country;
            }

            public Integer getAge() {
                return age;
            }

            public String getName() {
                return name;
            }

            public String getCountry() {
                return country;
            }
        }
        Person a = new Person("xianxian", "China", 17);
        System.out.print(a.getName());
    }
}
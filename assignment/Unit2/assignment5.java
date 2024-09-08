public class assignment5 {
    public static void main(String[] args) {
        class Animal {
            public Animal() {

            }

            public void makeSound() {
                System.out.println("Lizhen");
            }
        }

        class Cat extends Animal {
            public void makeSound() {
                System.out.println("bark");
            }
        }
        Animal cat = new Cat();
        cat.makeSound();
    }

}

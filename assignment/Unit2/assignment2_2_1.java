public class assignment2_2_1 {
    public static void main(String[] args) {
        abstract class Animal {
            abstract public void sound();
        }

        class Lion extends Animal {
            @Override
            public void sound() {
                System.out.println("Lion");
            }
        }

        class Tiger extends Animal {
            @Override
            public void sound() {
                System.out.println("Tiger");
            }
        }

        Animal tiger = new Tiger();
        Animal lion = new Lion();
        lion.sound();
        tiger.sound();
    }
}
public class assignment4 {
    public static void main(String[] args) {
        class Circle {
            private Integer radius;

            public Circle(Integer radius) {
                this.radius = radius;
            }

            public double calculateArea() {
                return radius * 3.1415;
            }

            public double calculateArea(double ratio) {
                return radius * 3.1415 * ratio;
            }
        }

        Circle c = new Circle(10);
        System.out.println(c.calculateArea());
        System.out.print(c.calculateArea(0.4));
    }
}

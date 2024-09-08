public class assignment2_2_4 {
    public static void main(String[] args) {
        interface Shape {
            abstract double getArea();
        }
        class Rectangle implements Shape {
            private double width, height;

            @Override
            public double getArea() {
                return width * height;
            }
        }

        class Circle implements Shape {
            private double r;

            @Override
            public double getArea() {
                return r * r * Math.PI;
            }
        }

        class Triangle implements Shape {
            private double width, height;

            @Override
            public double getArea() {
                return width * height / 2;
            }
        }
    }
}

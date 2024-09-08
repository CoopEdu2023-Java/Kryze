public class assignment6 {
    public static void main(String[] args) {
        class Shape {
            public Integer getArea() {
                return null;
            }
        }
        class Rectangle extends Shape {
            private Integer width, length;

            public Rectangle(Integer width, Integer length) {
                this.width = width;
                this.length = length;
            }

            public Integer getArea() {
                return length * width;
            }

        }

        Shape rec = new Rectangle(10, 10);
        System.out.println(rec.getArea());
    }

}

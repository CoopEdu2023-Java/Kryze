public class assignment2 {
    public static void main(String[] args) {
        class Rectangle {
            private Integer width, length;

            public Rectangle() {

            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public void setLength(Integer length) {
                this.length = length;
            }

            public Integer area() {
                return length * width;
            }

        }
        Rectangle r = new Rectangle();
        r.setLength(10);
        r.setWidth(10);
        System.out.print(r.area());
        ;
    }
}

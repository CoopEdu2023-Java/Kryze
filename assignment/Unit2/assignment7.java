public class assignment7 {
    public static void main(String[] args) {
        class Sports {
            public void play() {

            }
        }

        class Football extends Sports {
            public void play() {
                System.out.println("Football");
            }
        }

        class Basketball extends Sports {
            public void play() {
                System.out.println("Basketball");
            }
        }

        class Rugby extends Sports {
            public void play() {
                System.out.println("Rugby");
            }
        }

        Sports f = new Football();
        Sports b = new Basketball();
        Sports r = new Rugby();
        f.play();
        b.play();
        r.play();
    }
}

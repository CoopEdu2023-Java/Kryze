public class assignment3_2_11 {
    class MaxHeap {
        private int[] data;
        private int size;

        public MaxHeap(int capacity) {
            this.data = new int[capacity + 1];
            this.data[0] = 0;
            this.size = 0;
        }

        public void push(int x) {
            int i = ++this.size;
            for (; i > 1 && this.data[i / 2] < x; i /= 2) {
                this.data[i] = this.data[i / 2];
            }
            this.data[i] = x;
        }

        public int pop() {
            int max = this.data[1];
            int tmp = this.data[this.size--];
            int parent;
            int child;
            for (parent = 1; parent * 2 <= this.size; parent = child) {
                child = parent * 2;
                if (child != this.size && this.data[child] < this.data[child + 1]) {
                    child++;
                }
                if (tmp >= this.data[child]) {
                    break;
                } else {
                    this.data[parent] = this.data[child];
                }
            }
            this.data[parent] = tmp;
            return max;
        }

        public int peek() {
            return this.data[1];
        }

    }

    class MinHeap {
        private int[] data;
        private int size;

        public MinHeap(int capacity) {
            this.data = new int[capacity + 1];
            this.data[0] = 0;
            this.size = 0;
        }

        public void push(int x) {
            int i = ++this.size;
            for (; i > 1 && this.data[i / 2] > x; i /= 2) {
                this.data[i] = this.data[i / 2];
            }
            this.data[i] = x;
        }

        public int pop() {
            int min = this.data[1];
            int tmp = this.data[this.size--];
            int parent;
            int child;
            for (parent = 1; parent * 2 <= this.size; parent = child) {
                child = parent * 2;
                if (child != this.size && this.data[child] > this.data[child + 1]) {
                    child++;
                }
                if (tmp <= this.data[child]) {
                    break;
                } else {
                    this.data[parent] = this.data[child];
                }
            }
            this.data[parent] = tmp;
            return min;
        }

        public int peek() {
            return this.data[1];
        }
    }

    public static void main(String[] args) {

    }
}

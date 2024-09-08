public class assignment3_1_9 {
    public static class StackDemo<T> {
        private T[] data;
        private int top;

        public StackDemo(int capacity) {
            this.data = (T[]) new Object[capacity];
            this.top = -1;
        }

        public boolean isEmpty() {
            return this.top == -1;
        }

        public boolean isFull() {
            return this.top == this.data.length - 1;
        }

        public void push(T value) {
            if (isFull()) {
                throw new IllegalStateException("Stack is full");
            }
            this.data[++this.top] = value;
        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return this.data[this.top--];
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return this.data[this.top];
        }
    }

    public static void main(String[] args) {
        StackDemo<Integer> stack = new StackDemo<>(50);
    }
}

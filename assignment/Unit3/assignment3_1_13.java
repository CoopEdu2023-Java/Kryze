class assignment3_1_13 {
    public static class ArrayQueueDemo<T> {
        private T[] data;
        private int size;
        private int front;
        private int rear;

        public ArrayQueueDemo(int capacity) {
            this.data = (T[]) new Object[capacity];
            this.size = 0;
            this.front = 0;
            this.rear = 0;
        }

        private void checkQueueEmpty() {
            if (this.size == 0) {
                throw new IllegalStateException("Queue is empty");
            }
        }

        private void checkQueueFull() {
            if (this.size == this.data.length) {
                throw new IllegalStateException("Queue is full");
            }
        }

        public void enqueue(T value) {
            checkQueueFull();
            this.data[this.rear] = value;
            this.rear = (this.rear + 1) % this.data.length;
            this.size++;
        }

        public T dequeue() {
            checkQueueEmpty();
            T frontValue = this.data[this.front];
            this.front = (this.front + 1) % this.data.length;
            this.size--;
            return frontValue;
        }

        public T peek() {
            checkQueueEmpty();
            return this.data[this.front];
        }
    }

    public static void main(String[] args) {

    }
}

class assignment3_1_14 {

    public static class LinkedQueue<T> {
        private Node<T> front;
        private Node<T> rear;
        private int size;

        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        public LinkedQueue() {
            this.front = null;
            this.rear = null;
            this.size = 0;
        }

        private void checkQueueEmpty() {
            if (this.size == 0) {
                throw new IllegalStateException("Queue is empty");
            }
        }

        public void enqueue(T value) {
            Node<T> newNode = new Node<>(value);
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }

        public T dequeue() {
            checkQueueEmpty();
            T frontValue = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return frontValue;
        }

        public T peek() {
            checkQueueEmpty();
            return front.data;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
    }
}

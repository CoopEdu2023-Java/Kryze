public class assignment3_1_4 {

    public static class LinkedListDemo<T> {
        private Node<T> head;
        private int size;

        public LinkedListDemo() {
            this.head = null;
            this.size = 0;
        }

        private class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        public int size() {
            return this.size;
        }

        public void insert(int index, T value) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
            Node<T> newNode = new Node<>(value);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node<T> prev = getNode(index - 1);
                newNode.next = prev.next;
                prev.next = newNode;
            }
            size++;
        }

        public T delete(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            T deletedValue;
            if (index == 0) {
                deletedValue = head.data;
                head = head.next;
            } else {
                Node<T> prev = getNode(index - 1);
                deletedValue = prev.next.data;
                prev.next = prev.next.next;
            }
            size--;
            return deletedValue;
        }

        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node<T> current = getNode(index);
            return current.data;
        }

        public void set(int index, T value) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node<T> current = getNode(index);
            current.data = value;
        }

        private Node<T> getNode(int index) {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
    }

    public static void main(String[] args) {
        LinkedListDemo<Integer> list = new LinkedListDemo<>();

        list.insert(0, 10);
        list.insert(1, 20);
        list.insert(2, 30);
        list.insert(1, 15);

        System.out.println("List size: " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at index " + i + ": " + list.get(i));
        }

        list.delete(1);

        System.out.println("After deletion:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at index " + i + ": " + list.get(i));
        }

        list.set(1, 100);

        System.out.println("After setting:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at index " + i + ": " + list.get(i));
        }
    }
}

import java.util.Scanner;

public class assignment3_1_6 {
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
        Scanner scanner = new Scanner(System.in);
        String str;
        LinkedListDemo<Integer> first = new LinkedListDemo<>();
        LinkedListDemo<Integer> second = new LinkedListDemo<>();
        LinkedListDemo<Integer> third = new LinkedListDemo<>();
        str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            first.insert(i, ch - 48);
        }
        str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            second.insert(i, ch - 48);
        }
        int maxSize = Math.max(first.size(), second.size());
        if (first.size() < second.size()) {
            LinkedListDemo<Integer> temp = new LinkedListDemo<>();
            temp = first;
            first = second;
            second = temp;
        }
        int addition = 0, i;
        for (i = 0; i < maxSize; i++) {
            if (i > second.size() - 1) {
                third.insert(i, (addition + first.get(i) + 0) % 10);
                addition = (addition + first.get(i) + 0) / 10;
            } else {
                third.insert(i, (addition + first.get(i) + second.get(i)) % 10);
                addition = (addition + first.get(i) + second.get(i)) / 10;
            }

        }
        if (addition == 1)
            third.insert(i, addition);
        for (i = 0; i < third.size(); i++) {
            System.out.print(third.get(i));
        }
    }

}
import java.util.Scanner;

public class assignment3_1_8 {
    public static class DoublyLinkedListDemo<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;

        public DoublyLinkedListDemo() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        private class Node<T> {
            T data;
            Node<T> next;
            Node<T> prev;

            Node(T data) {
                this.data = data;
                this.next = null;
                this.prev = null;
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
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                }
            } else if (index == size) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                Node<T> prevNode = getNode(index - 1);
                Node<T> nextNode = prevNode.next;
                prevNode.next = newNode;
                newNode.prev = prevNode;
                newNode.next = nextNode;
                nextNode.prev = newNode;
            }
            size++;
        }

        public T delete(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node<T> nodeToRemove;
            if (index == 0) {
                nodeToRemove = head;
                head = head.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
            } else if (index == size - 1) {
                nodeToRemove = tail;
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                } else {
                    head = null;
                }
            } else {
                nodeToRemove = getNode(index);
                nodeToRemove.prev.next = nodeToRemove.next;
                nodeToRemove.next.prev = nodeToRemove.prev;
            }
            size--;
            return nodeToRemove.data;
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
            Node<T> current;
            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }
            return current;
        }

        public void removeNthFromEnd(int n) {

            Node<T> first = head;
            Node<T> second = head;

            for (int i = 0; i < n - 1; i++) {
                first = first.next;
            }

            if (first == null) {
                delete(0);
                return;
            }

            while (first.next != null) {
                first = first.next;
                second = second.next;
            }

            delete(getIndex(second));
        }

        private int getIndex(Node<T> node) {
            int index = 0;
            Node<T> current = head;
            while (current != null && current != node) {
                index++;
                current = current.next;
            }
            return index;
        }

        public void printList() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedListDemo<Integer> list = new DoublyLinkedListDemo<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insert(i, scanner.nextInt());
        }
        int removeIndex = scanner.nextInt();
        list.removeNthFromEnd(removeIndex);
        list.printList();
    }
}

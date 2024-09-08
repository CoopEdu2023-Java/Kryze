import java.util.Scanner;

public class assignment3_1_7 {

    public static class LinkedList<T extends Comparable<T>> {
        private Node<T> head;

        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        public void insert(T value) {
            if (head == null) {
                head = new Node<>(value);
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node<>(value);
            }
        }

        public Node<T> getHead() {
            return head;
        }

        public Node<T> mergeRecursive(Node<T> l1, Node<T> l2) {
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;

            if (l1.data.compareTo(l2.data) <= 0) {
                l1.next = mergeRecursive(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeRecursive(l1, l2.next);
                return l2;
            }
        }

        public void mergeWith(LinkedList<T> otherList) {
            this.head = mergeRecursive(this.head, otherList.getHead());
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

        LinkedList<Integer> firstList = new LinkedList<>();
        LinkedList<Integer> secondList = new LinkedList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            firstList.insert(scanner.nextInt());
        }
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            secondList.insert(scanner.nextInt());
        }
        firstList.mergeWith(secondList);
        firstList.printList();
    }
}

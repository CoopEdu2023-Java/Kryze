import java.util.Scanner;

public class assignment_3_1_12 {
    public static class LinkedStack<T> {
        private Node<T> top;
        private int size;

        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        public LinkedStack() {
            this.top = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public void push(T value) {
            Node<T> newNode = new Node<>(value);
            newNode.next = top;
            top = newNode;
            size++;
        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            T value = top.data;
            top = top.next;
            size--;
            return value;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return top.data;
        }

        public int size() {
            return size;
        }

        public void printStack() {
            Node<T> current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedStack<Character> tokens = new LinkedStack<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (!tokens.isEmpty()) {
                if ((input.charAt(i) == ')' && tokens.peek() == '(')
                        || (input.charAt(i) == ']' && tokens.peek() == '[')
                        || (input.charAt(i) == '}' && tokens.peek() == '{')) {
                    if (tokens.size() < 1) {
                        System.out.println("false");
                        return;
                    } else {
                        tokens.pop();
                    }
                } else {
                    tokens.push(input.charAt(i));
                }
            } else {
                tokens.push(input.charAt(i));
            }

        }
        if (tokens.isEmpty())
            System.out.println("true");
        else
            System.out.println("false");
    }
}

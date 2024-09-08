import java.util.Scanner;

public class assignment3_1_11 {
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

    public static int op(int first, int second, String operator) {
        switch (operator) {
            case "+":
                return first + second;

            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
        }

        return -1;
    }

    public static void main(String[] args) {
        LinkedStack<String> tokens = new LinkedStack<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            tokens.push(input);
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                Integer first, second;
                String operator;
                operator = tokens.pop();
                second = Integer.parseInt(tokens.pop());
                first = Integer.parseInt(tokens.pop());
                tokens.push(Integer.toString(op(first, second, operator)));
            }
        }
        System.out.println(tokens.peek());

    }

}

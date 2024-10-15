public class assignment3_2_8 {
    class AVLNode<T extends Comparable<T>> {
        T value;
        AVLNode<T> left;
        AVLNode<T> right;
        int height;

        public AVLNode(T x) {
            this.value = x;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        private int getHeight(AVLNode<T> node) {
            return node != null ? node.height : 0;
        }

        private int getBalanceFactor(AVLNode<T> node) {
            return getHeight(node.left) - getHeight(node.right);
        }

        private void updateHeight(AVLNode<T> node) {
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }

        private AVLNode<T> leftRotate(AVLNode<T> node) {
            AVLNode<T> newNode = node.right;
            node.right = newNode.left;
            newNode.left = node;
            updateHeight(node);
            updateHeight(newNode);
            return newNode;
        }

        private AVLNode<T> rightRotate(AVLNode<T> node) {
            AVLNode<T> newNode = node.left;
            node.left = newNode.right;
            newNode.right = node;
            updateHeight(node);
            updateHeight(newNode);
            return newNode;
        }

        private AVLNode<T> balance(AVLNode<T> node) {
            int balanceFactor = getBalanceFactor(node);
            if (balanceFactor == 2) {
                if (getBalanceFactor(node.left) >= 0) {
                    return rightRotate(node);
                } else if (getBalanceFactor(node.left) == -1) {
                    node.left = leftRotate(node.left);
                    return rightRotate(node);
                }
            }
            if (balanceFactor == -2) {
                if (getBalanceFactor(node.right) <= 0) {
                    return leftRotate(node);
                } else if (getBalanceFactor(node.right) == 1) {
                    node.right = rightRotate(node.right);
                    return leftRotate(node);
                }
            }
            return node;
        }

        private AVLNode<T> insert(AVLNode<T> root, T x) {
            if (root == null) {
                return new AVLNode<>(x);
            }
            if (x.compareTo(root.value) < 0) {
                root.left = insert(root.left, x);
            } else {
                root.right = insert(root.right, x);
            }
            updateHeight(root);
            return balance(root);
        }

        public AVLNode<T> delete(AVLNode<T> root, T x) {
            if (root == null) {
                return null;
            }
            if (x.compareTo(root.value) < 0) {
                root.left = delete(root.left, x);
            } else if (x.compareTo(root.value) > 0) {
                root.right = delete(root.right, x);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                root.value = findMin(root.right).value;
                root.right = delete(root.right, root.value);
            }
            updateHeight(root);
            return balance(root);
        }

        private AVLNode<T> findMin(AVLNode<T> node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        assignment3_2_8 tree = new assignment3_2_8();
        AVLNode<Integer> root = tree.new AVLNode<>(10);
        root = root.insert(root, 5);
        root = root.insert(root, 20);
        root = root.insert(root, 4);
        root = root.insert(root, 15);

        root = root.delete(root, 5);
    }
}

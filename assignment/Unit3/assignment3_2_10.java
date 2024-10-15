public class assignment3_2_10 {

    // AVLNode 定义
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

    public AVLNode<Integer> sortedArrayToBST(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);
    }

    private AVLNode<Integer> CreateBST(int nums[], int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        AVLNode<Integer> root = new AVLNode<>(nums[mid]);
        root.left = CreateBST(nums, l, mid - 1);
        root.right = CreateBST(nums, mid + 1, r);
        return root;
    }

    // 主程序
    public static void main(String[] args) {
    }
}

public class assignment3_2_1 {
    public class TreeNode<T> {
        private TreeNode left, right;
        private T val;

        public TreeNode(T val) {
            this.val = val;
        }

        public TreeNode(T val, TreeNode left, TreeNode right) {
            this.val = val;
            this.right = right;
            this.left = left;
        }

        public T getVal() {
            return this.val;
        }
    }

    public static void main(String[] args) {

    }
}

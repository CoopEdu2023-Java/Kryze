public class assignment3_2_7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        int sum = root.val >= low && root.val <= high ? root.val : 0;

        if (root.left != null) {
            sum += rangeSumBST(root.left, low, high);
        }

        if (root.right != null) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}

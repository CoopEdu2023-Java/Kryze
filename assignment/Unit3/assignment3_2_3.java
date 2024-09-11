import java.util.ArrayList;
import java.util.List;

public class assignment3_2_3 {

    public static class TreeNode {
        int val, layer = 0;
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

    public void dfs(TreeNode current, List<Integer> ans) {
        if (current == null)
            return;
        dfs(current.left, ans);
        ans.add(current.val);
        dfs(current.right, ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
}
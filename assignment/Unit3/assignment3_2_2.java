import java.util.ArrayList;
import java.util.List;

public class assignment3_2_2 {
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
        if (current != null) {
            ans.add(Integer.valueOf(current.val));
        } else {
            return;
        }
        dfs(current.left, ans);
        dfs(current.right, ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
}

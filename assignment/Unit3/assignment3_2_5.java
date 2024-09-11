import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class assignment3_2_5 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLayer = -1;
        root.layer = 0;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                if (current.left != null) {
                    queue.add(current.left);
                    current.left.layer = current.layer + 1;
                }

                if (current.right != null) {
                    current.right.layer = current.layer + 1;
                    queue.add(current.right);
                }

                if (current.layer > currentLayer) {
                    ans.add(new ArrayList<>());
                    currentLayer = current.layer;
                    ans.get(currentLayer).add(current.val);
                } else {
                    ans.get(currentLayer).add(current.val);
                }
            }

        }

        return ans;
    }
}

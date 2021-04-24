package leetcode;

public class InsertIntoBST701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val > val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                } else {
                    node = node.left;
                }
            } else if (node.val < val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                } else {
                    node = node.right;
                }
            }
        }
        return null;
    }
}

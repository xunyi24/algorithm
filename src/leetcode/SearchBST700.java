package leetcode;

public class SearchBST700 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            } else if (val > root.val) {
                root = root.right;
            } else if (val < root.val) {
                root = root.left;
            }
        }
        return null;
    }
}

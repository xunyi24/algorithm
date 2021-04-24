package leetcode;

public class TrimBST669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val > high) {
            TreeNode leftNode = trimBST(root.left, low, high);
            return leftNode;
        } else if (root.val < low) {
            TreeNode rightNode = trimBST(root.right, low, high);
            return rightNode;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}

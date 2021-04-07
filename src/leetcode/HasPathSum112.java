package leetcode;

public class HasPathSum112 {
    public static void main(String[] args) {

    }

    int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return traversal(root, 0);
    }

    public boolean traversal(TreeNode node, int treeSum) {
        if (node == null) {
            return false;
        }

        treeSum += node.val;
        if (node.left == null && node.right == null) {
            if (treeSum == target) return true;
        }
        if (node.left != null) {
            if (traversal(node.left, treeSum)) return true;
        }
        if (node.right != null) {
            return traversal(node.right, treeSum);
        }

        return false;
    }
}

package leetcode;

public class IsBalanced110 {
    int res = 0;
    public boolean isBalanced(TreeNode root) {
        int leftHigh = getTreeDepth(root.left);

        return getTreeDepth(root) != -1;
    }

    private int getTreeDepth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = getTreeDepth(node.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getTreeDepth(node.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }
}

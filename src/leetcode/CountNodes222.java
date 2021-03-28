package leetcode;

public class CountNodes222 {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCountNodes = countNodes(root.left);
        int rightCountNodes = countNodes(root.right);
        return 1 + leftCountNodes + rightCountNodes;
    }
}

package leetcode;

public class SumOfLeftLeaves404 {
    public static void main(String[] args) {

    }

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sum(root);
        return sum;
    }

    private void sum(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }

        sumOfLeftLeaves(node.left);
        sumOfLeftLeaves(node.right);
    }
}

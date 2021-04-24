package leetcode;

import java.util.Stack;

public class GetMinimumDifference530 {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            if (preNode != null && Math.abs(node.val - preNode.val) < min) {
                min = Math.abs(node.val - preNode.val);
            }
            preNode = node;
            root = node.right;
        }

        return min;
    }
}

package leetcode;

import java.util.Stack;

public class IsValidBST98 {
    public static void main(String[] args) {

    }

    TreeNode preNode;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }
        if (preNode != null && preNode.val > root.val) {
            return false;
        }
        preNode = root;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    /**
     * 中序遍历非递归
     */
    public boolean isValidBSTInorderNonRecursion(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> preStack = new Stack<>();
        preStack.push(root);
        while (!preStack.empty()) {
            TreeNode node = preStack.pop();

            preStack.push(preStack.pop().right);
            preStack.push(preStack.pop().left);
        }

        TreeNode preNode = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (preNode != null && preNode.val > node.val) {
                return false;
            }
            preNode = node;
            node = node.right;
        }

        return true;
    }
}

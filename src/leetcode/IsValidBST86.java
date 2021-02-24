package leetcode;

import java.util.Stack;

public class IsValidBST86 {
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
        if (preNode != null && preNode.val >= root.val) {
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
        TreeNode preNode = null;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (root != null || !treeNodeStack.empty()) {
            while (root != null) {
                treeNodeStack.push(root);
                root = root.left;
            }

            TreeNode node = treeNodeStack.pop();
            if (preNode != null && preNode.val >= node.val) {
                return false;
            }

            preNode = node;
            root = node.right;
        }
        return true;
    }
}

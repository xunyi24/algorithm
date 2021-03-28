package leetcode;

import java.util.Stack;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Stack<TreeNode> treeNodes = new Stack<>();
        if (root.left != null && root.right != null) {
            treeNodes.push(root.left);
            treeNodes.push(root.right);
        } else {
            return false;
        }

        while (!treeNodes.isEmpty()) {
            Stack<TreeNode> treeNodes1 = new Stack<>();
            if (treeNodes.size() % 2 != 0) {
                return false;
            }
            while (!treeNodes.isEmpty()) {
                TreeNode t1 = treeNodes.pop();
                TreeNode t2 = treeNodes.pop();
                if (t1 == null && t2 == null) {
                    continue;
                }
                if (t1 == null || t2 == null) {
                    return false;
                }
                if (t1.val != t2.val) {
                    return false;
                }

                treeNodes1.push(t1.left);


                treeNodes1.push(t2.right);


                treeNodes1.push(t1.right);


                treeNodes1.push(t2.left);

            }
            treeNodes = treeNodes1;
        }

        return true;
    }
}

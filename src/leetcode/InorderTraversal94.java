package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> nodes = new Stack<>();
        TreeNode index = root;
        while (index != null || !nodes.empty()) {
            while (index != null) {
                nodes.push(index);
                index = index.left;
            }
            TreeNode node = nodes.pop();
            res.add(node.val);
            index = node.right;
        }

        return res;
    }
}

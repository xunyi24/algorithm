package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            allPaths(root, "");
        }
        return res;
    }

    public void allPaths(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            path = path + node.val;
            res.add(path);
            return;
        }
        path = path + node.val + "->";
        if (node.left != null) {
            allPaths(node.left, path);
        }
        allPaths(node.right, path);
    }
}

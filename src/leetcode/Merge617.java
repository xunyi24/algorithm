package leetcode;

public class Merge617 {
    public TreeNode merge(TreeNode tree1, TreeNode tree2) {
        if (tree1 != null && tree2 == null) {
            return tree1;
        }
        if (tree1 == null && tree2 != null) {
            return tree2;
        }
        tree2.val += tree1.val;
        tree2.left = merge(tree1.left, tree2.left);
        tree2.right = merge(tree1.right, tree2.right);
        return tree2;
    }
}

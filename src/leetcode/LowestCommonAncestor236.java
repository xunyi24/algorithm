package leetcode;

public class LowestCommonAncestor236 {
    TreeNode pNode, qNode, lowestCommonNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pNode = p;
        qNode = q;
        findCommonAncestor(root);
        return lowestCommonNode;
    }

    private boolean findCommonAncestor(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node == pNode) {
            lowestCommonNode = node;
            return true;
        }
        if (node == qNode) {
            lowestCommonNode = node;
            return true;
        }
        boolean first = findCommonAncestor(node.left);
        boolean second = findCommonAncestor(node.right);
        if (first && second) {
            lowestCommonNode = node;
            return true;
        }
        return first || second;
    }
}

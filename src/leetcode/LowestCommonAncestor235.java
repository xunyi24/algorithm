package leetcode;

public class LowestCommonAncestor235 {
    TreeNode pNode, qNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (p.val > q.val) {
//            pNode = p;
//            qNode = q;
//        } else {
//            pNode = q;
//            qNode = p;
//        }
//        return findLowestCommonNode(root);
        TreeNode node = root;
        while (node != null) {
            if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else {
                break;
            }
        }
        return node;
    }

    private TreeNode findLowestCommonNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.val > pNode.val && node.val > qNode.val)  {
            return node;
        }
        TreeNode node1 = findLowestCommonNode(node.left);
        if (node1 != null) {
            return node1;
        }
        TreeNode node2 = findLowestCommonNode(node.right);
        if (node2 != null) {
            return node2;
        }
        return null;
    }
}

package leetcode;

public class FindBottomLeftValue513 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode5.left = treeNode7;
        treeNode5.right = treeNode8;

        System.out.println(new FindBottomLeftValue513().findBottomLeftValue(treeNode1));
    }

    int leftValue;
    int maxDepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        leftValue = root.val;
        traversal(root, 1);
        return leftValue;
    }

    public void traversal(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            leftValue = node.val;
        }
        if (node.left != null) {
            traversal(node.left, depth + 1);
        }
        if (node.right != null) {
            traversal(node.right, depth + 1);
        }
    }
}

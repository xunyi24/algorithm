package leetcode;

public class ConvertBST538 {
    public TreeNode convertBST(TreeNode root) {
        convertBSTToGreaterTree(root);
        return root;
    }

    int preVal = 0;
    private void convertBSTToGreaterTree(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBSTToGreaterTree(root.right);
        root.val += preVal;
        preVal = root.val;
        convertBSTToGreaterTree(root.left);
    }
}

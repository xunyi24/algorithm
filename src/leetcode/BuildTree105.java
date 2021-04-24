package leetcode;

import java.util.HashMap;

public class BuildTree105 {
    HashMap<Integer, Integer> preorderMap = new HashMap<>();
    int[] pre;
    int[] in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            preorderMap.put(inorder[i], i);
        }
        pre = preorder;
        in = inorder;
        return buildHelper(0, in.length - 1, 0, pre.length - 1);
    }

    private TreeNode buildHelper(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(pre[ps]);
        int rootIndexInInorder = preorderMap.get(pre[ps]);

        root.left = buildHelper(is, rootIndexInInorder - 1, ps + 1, ps + rootIndexInInorder - is);
        root.right = buildHelper(rootIndexInInorder + 1, ie, ps + rootIndexInInorder - is + 1, pe);

        return root;
    }
}

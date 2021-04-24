package leetcode;

import java.util.HashMap;

public class BuildTree106 {
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int[] in;
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        in = inorder;
        post = postorder;
        return buildHelper(0, in.length - 1, 0, post.length - 1);
    }

    private TreeNode buildHelper(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(post[pe]);
        int rootIndexInInorder = inorderMap.get(post[pe]);

        root.left = buildHelper(is, rootIndexInInorder - 1, ps, ps + rootIndexInInorder - is - 1);
        root.right = buildHelper(rootIndexInInorder + 1, ie, ps + rootIndexInInorder - is, pe - 1);

        return root;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMode501 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);

        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;

        System.out.println(Arrays.toString(new FindMode501().findMode(treeNode1)));

    }

    List<Integer> res = new ArrayList<>();
    TreeNode node = null;
    int count;
    int maxCount = 1;
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        update(root);
        inOrder(root.right);
    }

    private void update(TreeNode curNode) {
        if (node == null) {
            count = 1;
            maxCount = 1;
        } else if (curNode.val == node.val) {
            count++;
            if (count == maxCount) {
                res.add(curNode.val);
            }
            if (count > maxCount) {
                maxCount = count;
                res.clear();
                res.add(curNode.val);
            }
        } else if (curNode.val != node.val) {
            count = 1;
        }
        node = curNode;
    }
}

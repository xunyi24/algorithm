package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IsSubtree572 {
    public static void main(String[] args) {
        TreeNode s = new TreeNode(1);
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(1);
        TreeNode s3 = new TreeNode(1);
        TreeNode s4 = new TreeNode(1);
        TreeNode s5 = new TreeNode(2);
        s.right = s1;
        s1.right = s2;
        s2.right = s3;
        s3.right = s4;
        s4.left = s5;

        TreeNode t = new TreeNode(1);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(2);
        t.right = t1;
        t1.right = t2;
        t2.right = t3;
        t3.left = t4;

        System.out.println(new IsSubtree572().isSubtree(s, t));
    }

    int maxValue = Integer.MIN_VALUE;
    int leftValue, rightValue;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<Integer> sList = new ArrayList<>();
        List<Integer> tList = new ArrayList<>();
        //用于记录左子节点或者右子节点为空的情况，不能直接设置某个数字，否则可能重复判断导致错误
        getMaxValue(s);
        getMaxValue(t);
        leftValue = maxValue + 1;
        rightValue = maxValue + 2;
        getTreeNodeVal(s, sList);
        getTreeNodeVal(t, tList);
        int[] main = new int[sList.size()];
        for (int i = 0; i < sList.size(); i++) {
            main[i] = sList.get(i);
        }
        int[] pattern = new int[tList.size()];
        for (int i = 0; i < tList.size(); i++) {
            pattern[i] = tList.get(i);
        }
        int[] next = new int[pattern.length];
        getNext(pattern, next);

        int i = 0, j = 0;
        while (i < main.length && j < pattern.length) {
            if (main[i] == pattern[j]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }
            if (j == next.length) {
                return true;
            }
        }
        return false;
    }

    private void getMaxValue(TreeNode node) {
        if (node == null) {
            return;
        }
        maxValue = Math.max(node.val, maxValue);
        getMaxValue(node.left);
        getMaxValue(node.right);
    }

    private void getTreeNodeVal(TreeNode node, List<Integer> valArray) {
        if (node == null) {
            return;
        }
        valArray.add(node.val);
        if (node.left == null) {
            valArray.add(leftValue);
        } else {
            getTreeNodeVal(node.left, valArray);
        }
        if (node.right == null) {
            valArray.add(rightValue);
        } else {
            getTreeNodeVal(node.right, valArray);
        }
    }

    private void getNext(int[] pattern, int[] next) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[j] != pattern[i]) {
                j = next[j - 1];
            }
            if (pattern[j] == pattern[i]) {
                next[i] = ++j;
            }
        }
    }

}

package leetcode;

import java.util.HashMap;

public class ConstructMaximumBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildHelper(0, nums.length - 1, nums);
    }

    private TreeNode buildHelper(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }

        int maxValueIndex = getMaxValueIndex(start, end, nums);
        int maxValue = nums[maxValueIndex];

        TreeNode root = new TreeNode(maxValue);
        root.left = buildHelper(start, maxValueIndex - 1, nums);
        root.right = buildHelper(maxValueIndex + 1, end, nums);
        return root;
    }

    private int getMaxValueIndex(int start, int end, int[] nums) {
        int maxValueIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxValueIndex]) {
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }
}

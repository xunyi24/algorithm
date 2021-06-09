package leetcode;

public class CanJump55 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        if (nums.length == 1) return true;
        // 不断延长可以覆盖的范围, 看最后是否可以覆盖到末尾
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, nums[i] + i);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }

    /**
     * 回溯做法, 超时; (采用从最大值跳跃, 逐渐缩小跳跃步数的方式应该可以不超时)
     */
    public boolean canJump1(int[] nums) {
        return backtracking(nums, 0);
    }

    private boolean backtracking(int[] nums, int index) {
        if (nums[index] + index + 1 >= nums.length) return true;

        int step = 1;
        while (step <= nums[index]) {
            if (backtracking(nums, index + step)) return true;
            step++;
        }
        return false;
    }
}

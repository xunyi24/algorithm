package leetcode;

public class MinSubArrayLen209 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 11;
        MinSubArrayLen209 minSubArrayLen209 = new MinSubArrayLen209();
        System.out.println(minSubArrayLen209.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int minLength = Integer.MAX_VALUE;
        int left = 0, right = 0, length = nums.length, sum = 0;

        while (right < length) {
            sum += nums[right++];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left++];
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }

        return minLength;
    }
}

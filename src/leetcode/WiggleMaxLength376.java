package leetcode;

public class WiggleMaxLength376 {
    public static void main(String[] args) {
        int length = new WiggleMaxLength376().wiggleMaxLength(new int[]{1, 1, 17, 5});
        System.out.println(length);
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int maxLength = 1;

        int startIndex = 1;
        while (startIndex < nums.length) {
            if ((nums[startIndex] - nums[startIndex - 1]) != 0) {
                break;
            }
            startIndex++;
        }

        if (startIndex == nums.length) return maxLength;

        int preDiff = nums[startIndex] - nums[startIndex - 1], curDiff;
        for (int i = startIndex + 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((preDiff > 0 && curDiff < 0) || (preDiff < 0 && curDiff > 0)) {
                maxLength++;
                // 不能每次更新pre。考虑数字连续相等的情况
                preDiff = curDiff;
            }
        }

        return maxLength + 1;
    }
}

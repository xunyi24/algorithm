package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LargestSumAfterKNegations1005 {
    public static void main(String[] args) {
        LargestSumAfterKNegations1005 lsakn = new LargestSumAfterKNegations1005();
        int[] nums = {-8, 3, -5, -3, -5, -2, 1, 5, 6};
        lsakn.largestSumAfterKNegations(nums, 6);
        System.out.println(Arrays.stream(nums).sum());
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        // 绝对值最小的数字
        int minABSNumber = Integer.MAX_VALUE;
        int numberIndex = 0, kIndex = 0;
        while (kIndex < k && numberIndex < nums.length) {
            if (nums[numberIndex] < 0) {
                nums[numberIndex] = -nums[numberIndex];
                // 取最小的绝对值
                minABSNumber = Math.min(minABSNumber, nums[numberIndex]);
                kIndex++;
                numberIndex++;
            } else {
                break;
            }
        }
        result = Arrays.stream(nums).sum();
        if (kIndex < k) {
            minABSNumber = Math.min(minABSNumber, nums[numberIndex]);
            if ((k - kIndex) % 2 != 0) {
                result -= 2 * minABSNumber;
            }
        }
        return result;
    }
}

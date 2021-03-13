package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int length = nums.length;
        if (length < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            if ((nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) > target) {
                break;
            }

            if ((nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1]) < target) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                if ((nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) > target) {
                    break;
                }

                if ((nums[i] + nums[j] + nums[length - 2] + nums[length - 1]) < target) {
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if ((nums[i] + nums[j] + nums[left] + nums[right]) < target) {
                        left++;
                    } else if ((nums[i] + nums[j] + nums[left] + nums[right]) > target) {
                        right--;
                    } else {
                        List<Integer> fourSum = new ArrayList<>();
                        fourSum.add(nums[i]);
                        fourSum.add(nums[j]);
                        fourSum.add(nums[left]);
                        fourSum.add(nums[right]);
                        res.add(fourSum);

                        while(left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }

        return res;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) {
        ThreeSum15 threeSum15 = new ThreeSum15();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum15.threeSum(nums);
        System.out.println(res);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        //如果数组长度小于3 则直接返回空数组
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //排序后如果第一个数大于0，那么以后的数也会大于0，不可能三数之和等于0，直接返回空数组
            if (nums[i] > 0) {
                return res;
            }

            //如果后一个数与前一个数相等，说明target相等，那么得出的答案也与前一个数相等，则会出现重复的数组，所以直接跳过
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1, target = -nums[i];
            while (left < right) {
                if ((nums[left] + nums[right]) > target) {
                    right--;
                } else if ((nums[left] + nums[right]) < target) {
                    left++;
                } else {
                    List<Integer> threeNums = new ArrayList<>();
                    threeNums.add(nums[i]);
                    threeNums.add(nums[left]);
                    threeNums.add(nums[right]);
                    res.add(threeNums);

                    //添加完成之后继续扫描 nums[left]增大, nums[right]减小 所以还可能有符合条件的组合，并且在这个过程中跳过重复的元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return res;
    }
}

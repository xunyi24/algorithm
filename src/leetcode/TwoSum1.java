package leetcode;

import java.util.HashMap;

public class TwoSum1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        HashMap<Integer, Integer> indexValueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexValueMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (indexValueMap.containsKey(target - nums[i])) {
                int res2 = indexValueMap.get(target - nums[i]);
                if (res2 != i) {
                    res[0] = i;
                    res[1] = res2;
                }
            }
        }

        return res;
    }
}

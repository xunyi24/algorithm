package leetcode;

import java.util.*;

public class FindSubsequences491 {
    public static void main(String[] args) {
        FindSubsequences491 subsequences = new FindSubsequences491();
        System.out.println(subsequences.findSubsequences(new int[]{1, 2, 1, 4}));
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subsequences = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) return res;
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 每一层中出现的元素
        boolean[] levelNums = new boolean[401];

        for (int i = startIndex; i < nums.length; i++) {
            if ((!subsequences.isEmpty() && nums[i] < subsequences.get(subsequences.size() - 1)) || levelNums[nums[i] + 200]) {
                continue;
            }
            levelNums[nums[i] + 200] = true;
            subsequences.add(nums[i]);
            if (subsequences.size() > 1) {
                res.add(new ArrayList<>(subsequences));
            }
            backtracking(nums, i + 1);
            subsequences.remove(subsequences.size() - 1);
        }
    }
}

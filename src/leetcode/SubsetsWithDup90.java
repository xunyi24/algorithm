package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup90 {
    public static void main(String[] args) {
        SubsetsWithDup90 subsets = new SubsetsWithDup90();
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subsets = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        res.add(new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        for (int i = startIndex; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && i > startIndex) continue;
            subsets.add(nums[i]);
            res.add(new ArrayList<>(subsets));
            backtracking(nums, i + 1);
            subsets.remove(subsets.size() - 1);
        }
    }
}

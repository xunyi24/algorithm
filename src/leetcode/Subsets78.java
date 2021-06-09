package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets78 subsets78 = new Subsets78();
        subsets78.subsets(nums);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subsets = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        res.add(new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        for (int i = startIndex; i < nums.length; i++) {
            subsets.add(nums[i]);
            res.add(new ArrayList<>(subsets));
            backtracking(nums, i + 1);
            subsets.remove(subsets.size() - 1);
        }
    }
}

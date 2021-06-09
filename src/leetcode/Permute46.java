package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permute46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Permute46().permute(nums);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> permute = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] appeared = new boolean[nums.length];
        backtracking(nums, appeared);
        return res;
    }

    private void backtracking(int[] nums, boolean[] appeared) {
        if (permute.size() == nums.length) {
            res.add(new ArrayList<>(permute));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (appeared[i]) continue;
            appeared[i] = true;
            permute.add(nums[i]);
            backtracking(nums, appeared);
            appeared[i] = false;
            permute.remove(permute.size() - 1);
        }
    }
}

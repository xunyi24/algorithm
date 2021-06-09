package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique47 {
    public static void main(String[] args) {
        PermuteUnique47 permuteUnique47 = new PermuteUnique47();
        permuteUnique47.permuteUnique(new int[]{1, 1, 1, 2});
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> permuteUnique = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        if (permuteUnique.size() == nums.length) {
            res.add(new ArrayList<>(permuteUnique));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 1.使用 used[i - 1] == true判断 判断的是同一树枝与前一位是否重复
            // 2.使用 used[i - 1] == false判断 判断的是同一树层与前一位是否重复
            // 如下注释所示, 同一树枝中的是递归到下层, 同一树层中的是在本层下次循环判断.  经验证同一树层的判断效率更高
            if (i != 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                // 同一树枝
                used[i] = true;
                permuteUnique.add(nums[i]);
                backtracking(nums, used);
                // 同一树层
                used[i] = false;
                permuteUnique.remove(permuteUnique.size() - 1);
            }
        }
    }
}

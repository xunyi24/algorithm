package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        CombinationSum39 combinationSum39 = new CombinationSum39();
        combinationSum39.combinationSum(new int[]{2, 3, 5}, 8);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> combinationSum = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0);
        Arrays.sort(candidates);
        return res;
    }

    private void backtracking(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(combinationSum));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }

            combinationSum.add(candidates[i]);
            // 得往前走 所以下个要选取的数要从index = i开始, 不能从index = 0开始, 就是说我已经在一个组合中选过跳过的数字不能再选择;
            // 例如我选了2, 2, 3下一个循环要从3开始选择, 而不能从开始的 [index = 0] = 2开始选择
            // 组合
            backtracking(candidates, target - candidates[i], i);
            combinationSum.remove(combinationSum.size() - 1);
        }
    }
}

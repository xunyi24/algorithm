package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum40 {
    public static void main(String[] args) {
        new CombinationSum40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> combinationSum = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates, target, 0, 0, used);
        return res;
    }

    private void backtracking(int[] candidates, int target, int sum, int index, boolean[] used) {
        if (sum == target) {
            res.add(new ArrayList<>(combinationSum));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) continue;
            if (sum + candidates[i] > target) {
                return;
            }
            sum += candidates[i];
            combinationSum.add(candidates[i]);
            // 带入下一层表示同一个树枝中可以有相同的数字, 因为在上面的判断条件中判断的是前一个used[i] = false
            used[i] = true;
            backtracking(candidates, target, sum, i + 1, used);
            sum -= candidates[i];
            combinationSum.remove(combinationSum.size() - 1);
            // used[i] 默认就是false 代表在同一树层中的前一个数字不能和后一个数字相同
            used[i] = false;
        }
    }

    private void backtracking2(int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(combinationSum));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 这里判断的是同一层和同一树枝的概念,
            // 在同一个树枝中, 第一次进入的i == index 是可以相等的,
            // 但是下一个的数字如果还相等 就代表是在同一层中去值了, 这时 i > index continue
            // 举例 [1,1,1,1] 第一层中选择了1之后, 在backtracking2 中的同一个树枝中还可以再次选择index = 1的值1,
            // 但是在这一层 当遍历到 i = 2时, i > index = 1, 因为是在同一层, 所以continue
            if (i != 0 && candidates[i] == candidates[i - 1] && i > index) continue;
            if (sum + candidates[i] > target) {
                return;
            }
            sum += candidates[i];
            combinationSum.add(candidates[i]);
            backtracking2(candidates, target, sum, i + 1);
            sum -= candidates[i];
            combinationSum.remove(combinationSum.size() - 1);
        }
    }

    /**
     * 总结: 组合中使用回溯其实就是在一棵树中不断的选择分支, 在本题中可以出现相同的数字就是在同一树枝中可以出现相同的数字
     * 但是不可以出现重复的组合 意思就是在同一树层中不能出现相同的数字,
     * 所以可以通过used数组或者判断i与index的关系这两种方式来判断是在同一树枝中还是同一树层中
     * 判断 重复数字是在同一树枝中还是同一树层中是解决本题的关键
     */
}

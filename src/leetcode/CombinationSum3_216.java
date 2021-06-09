package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216 {
    public static void main(String[] args) {
        CombinationSum3_216 combinationSum3_216 = new CombinationSum3_216();
        combinationSum3_216.combinationSum3(3, 7);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> combinationSum = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(1, k, n);
        return res;
    }

    private void backtracking(int index, int k, int n) {
        if (combinationSum.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(combinationSum));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (n - i < 0) {
                return;
            }
            combinationSum.add(i);
            backtracking(i + 1, k, n - i);
            combinationSum.remove(combinationSum.size() - 1);
        }
    }
}

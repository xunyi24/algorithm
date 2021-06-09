package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combine77 {
    public static void main(String[] args) {
        Combine77 combine77 = new Combine77();
        combine77.combine(4, 2);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(0, n, k);
        return res;
    }

    /**
     *
     * @param index 从第几个元素开始遍历
     * @param n 给定序列的最大值
     * @param k 组合在给定序列中的数量
     */
    private void backtracking(int index, int n, int k) {
        if (combine.size() == k) {
            res.add(new ArrayList<>(combine));
            return;
        }

        for (int j = index + 1; j <= n - (k - combine.size()) + 1; j++) {
            combine.add(j);
            backtracking(j, n, k);
            combine.remove(combine.size() - 1);
        }
    }
}

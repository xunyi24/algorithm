package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount454 {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> ab = new HashMap<>();
        for (int k : A) {
            for (int i : B) {
                int sumAB = k + i;
                if (ab.containsKey(sumAB)) {
                    ab.put(sumAB, ab.get(sumAB) + 1);
                } else {
                    ab.put(sumAB, 1);
                }
            }
        }

        for (int k : C) {
            for (int i : D) {
                int target = -(k + i);
                if (ab.containsKey(target)) {
                    res += ab.get(target);
                }
            }
        }

        return res;
    }
}

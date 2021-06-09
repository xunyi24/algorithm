package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals435 {
    public static void main(String[] args) {

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int rightIndex = intervals[0][1], count = 1; //非交叉区间个数
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= rightIndex) {
                count++;
                rightIndex = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}

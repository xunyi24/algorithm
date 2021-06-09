package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots452 {
    public static void main(String[] args) {
        // {3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}
        // {-2147483646,-2147483645},{2147483646,2147483647}
        // {9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        FindMinArrowShots452 findMinArrowShots452 = new FindMinArrowShots452();
        findMinArrowShots452.findMinArrowShots(points);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int minArrow = 0;
        int minRightIndex = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (minRightIndex < points[i][0]) {
                minArrow++;
                minRightIndex = points[i][1];
            }
            else minRightIndex = Math.min(minRightIndex, points[i][1]);
        }

        return minArrow + 1;
    }
}

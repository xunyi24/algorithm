package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue406 {
    public static void main(String[] args) {
        int[][] ints = {{5, 0}, {4, 4}};
        System.out.println(ints[0][0]);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        List<int[]> orderQueue = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            orderQueue.add(people[i][1], people[i]);
        }

        return orderQueue.toArray(new int[orderQueue.size()][]);
    }
}

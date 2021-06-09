package leetcode;

import java.util.Arrays;

public class Candy135 {
    public static void main(String[] args) {
        Candy135 candy135 = new Candy135();
        candy135.candy(new int[]{1, 0, 2});
    }

    public int candy(int[] ratings) {
        int[] candyNum = new int[ratings.length];
        Arrays.fill(candyNum, 1);
        // 找右孩子大于左孩子的
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candyNum[i] = candyNum[i - 1] + 1;
        }

        // 找左孩子大于右孩子的
        for (int i = ratings.length - 2; i >= 0 ; i--) {
            // 贪心 要保证中间孩子的糖果数量既要大于左边又要大于右边 所以取最大值
            if (ratings[i] > ratings[i + 1]) candyNum[i] = Math.max(candyNum[i], candyNum[i + 1] + 1);
        }

        // 上边代码倒过来也是成立的

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candyNum[i] = candyNum[i + 1] + 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candyNum[i] = Math.max(candyNum[i], candyNum[i - 1] + 1);
        }

        int sumCandy = 0;
        for (int j : candyNum) {
            sumCandy += j;
        }
        return sumCandy;
    }
}

package leetcode;

import java.util.Arrays;

public class Reverse7 {
    public static void main(String[] args) {
        Reverse7 reverse7 = new Reverse7();
        int res = reverse7.reverse(-1230);
        System.out.println(Integer.MIN_VALUE);
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int res = 0;
        while (x != 0) {
            int t = x % 10;
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && t > 7) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && t < -8) {
                return 0;
            }
            res = res * 10 + t;
            x = x / 10;
        }

        return res;
    }
}

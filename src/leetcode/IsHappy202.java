package leetcode;

import java.util.HashSet;
import java.util.Set;

public class IsHappy202 {
    public static void main(String[] args) {
        IsHappy202 isHappy202 = new IsHappy202();
        System.out.println(isHappy202.isHappy(19));
    }

    public boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(n);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int t = 0;
        while (n != 0) {
            int i = n % 10;
            n = n / 10;
            t = t + i * i;
        }

        return t;
    }
}

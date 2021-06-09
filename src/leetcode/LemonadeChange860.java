package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LemonadeChange860 {
    public static void main(String[] args) {
        int[] bills = {5,5,5,5,10,5,20,20,5,5,5,5,5,10,5,5,5,20,5,5,5,5,5,10,20,5,20,20,10,5,20,20,5,10,5,5,5,5,10,20,5,5,5,10,10};
        LemonadeChange860 lemonadeChange860 = new LemonadeChange860();
        lemonadeChange860.lemonadeChange(bills);
    }
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    ten++;
                    five--;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (five > 0 && ten > 0) {
                    twenty++;
                    five--;
                    ten--;
                } else if (five > 2) {
                    twenty++;
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

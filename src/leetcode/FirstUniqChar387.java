package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FirstUniqChar387 {
    public static void main(String[] args) {
        FirstUniqChar387 f = new FirstUniqChar387();
        String s = "loveleetcode";
        int a = f.firstUniqChar(s);
        System.out.println(a);
    }

    public int firstUniqChar(String s) {
        if (s.isEmpty()) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        int[] charTimesArray = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            charTimesArray[aChar - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (charTimesArray[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}

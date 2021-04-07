package leetcode;

import java.util.HashSet;
import java.util.Set;

public class RepeatedSubstringPattern459 {
    public static void main(String[] args) {
        RepeatedSubstringPattern459 r459 = new RepeatedSubstringPattern459();

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        System.out.println(set.remove('c'));
        System.out.println(set.remove('c'));
        System.out.println(set.remove('g'));
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        getNext(s, next);
        return next[s.length() - 1] != 0 && s.length() % (s.length() - next[s.length() - 1]) == 0;
    }

    private void getNext(String s, int[] next) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                next[i] = ++j;
            }
        }
    }
}

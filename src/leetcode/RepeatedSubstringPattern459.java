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
        char[] chars = s.toCharArray();
        Set<Character> appearChar = new HashSet<>();

        for (char aChar : chars) {
            appearChar.add(aChar);
        }

        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            appearChar.remove(chars[i]);
            if (appearChar.size() == 0) {
                end = i;
            }
        }

        int start = 0;
        String pattern = s.substring(start, end + 1);
        if (pattern != s.substring(end + 1, end + 1 + end)) {

        }
        return false;
    }
}

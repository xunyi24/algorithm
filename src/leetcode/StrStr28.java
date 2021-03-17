package leetcode;

import java.util.Arrays;

public class StrStr28 {
    public static void main(String[] args) {
        StrStr28 strStr28 = new StrStr28();
        int[] res = strStr28.next("hello");
        System.out.println(strStr28.strStr("mississipii", "issipi"));
    }

    /**
     * KMP算法
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int start = 0, end = needle.length();
        while (end <= haystack.length()) {
            if (haystack.substring(start, end).equals(needle)) {
                return start;
            } else {
                start++;
                end++;
            }
        }

        return -1;
    }

    /**
     * 求next数组 最长前缀与后缀相等的长度
     */
    public int[] next(String needle) {
        //前缀的index，也表示最长相等的前缀与后缀长度
        int j = 0;
        int[] next = new int[needle.length()];
        char[] chars = needle.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}

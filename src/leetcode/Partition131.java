package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Partition131 {
    List<List<String>> res = new ArrayList<>();
    List<String> palindromeString = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }


    private void backtracking(String s, int index) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(palindromeString));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (!isPalindromeString(s, index, i)) continue;
            palindromeString.add(s.substring(index, i + 1));
            backtracking(s, i + 1);
            palindromeString.remove(palindromeString.size() - 1);
        }
    }

    private boolean isPalindromeString(String string, int left, int right) {
        if (string == null || string.isEmpty()) return false;
        while (left < right) if (string.charAt(left++) != string.charAt(right--)) return false;
        return true;
    }
}

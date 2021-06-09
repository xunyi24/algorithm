package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations17 {
    Map<Integer, String> numberToString = new HashMap<>();
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        numberToString.put(2, "abc");
        numberToString.put(3, "def");
        numberToString.put(4, "ghi");
        numberToString.put(5, "jkl");
        numberToString.put(6, "mno");
        numberToString.put(7, "pqrs");
        numberToString.put(8, "tuv");
        numberToString.put(9, "wxyz");

        backtracking(digits, 0);
        return res;
    }

    public void backtracking(String digits, int stringIndex) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int number = digits.charAt(stringIndex) - '0';
        String s = numberToString.get(number);
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            sb.append(c);
            backtracking(digits, stringIndex + 1);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}

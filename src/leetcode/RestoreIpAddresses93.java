package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses93 {
    public static void main(String[] args) {
        RestoreIpAddresses93 r93 = new RestoreIpAddresses93();
        List<String> res = r93.restoreIpAddresses("010010");
        System.out.println(res);
    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return res;
    }

    private void backtracking(String s, int index, int level) {
        if (level >= 4) {
            if (sb.length() - 4 == s.length()) {
                String resString = sb.substring(0, sb.length() - 1);
                res.add(resString);
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (!isValidString(s, index, i)) return;
            sb.append(s, index, i + 1);
            sb.append(".");
            level++;
            backtracking(s, i + 1, level);
            level--;
            sb.delete(sb.length() - (i - index) - 2, sb.length());
        }
    }

    private boolean isValidString(String s, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) return true;
        if (rightIndex - leftIndex > 0 && s.charAt(leftIndex) == '0') return false;
        return Long.parseLong(s.substring(leftIndex, rightIndex + 1)) <= 255L;
    }
}

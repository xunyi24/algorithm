package leetcode;

public class LongestCommonSubsequence1143 {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[m][n] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            char c = text1.charAt(i);
            for (int j = 0; j < n; j++) {
                if (c == text2.charAt(j)) {
                    dp[m + 1][n + 1] = dp[m][n] + 1;
                } else {
                    dp[m + 1][n + 1] = Math.max(dp[m][n + 1], dp[m + 1][n]);
                }
            }
        }

        return dp[m][n];
    }
}

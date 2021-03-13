package leetcode;

public class GenerateMatrix59 {
    public static void main(String[] args) {

    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, bottom = n - 1, top = 0, times = n * n, nums = 1;

        while (nums <= times) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = nums++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = nums++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = nums++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = nums++;
            }
            left++;
        }

        return matrix;
    }
}

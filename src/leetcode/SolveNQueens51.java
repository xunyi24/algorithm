package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens51 {
    public static void main(String[] args) {
        SolveNQueens51 solveNQueens51 = new SolveNQueens51();
        solveNQueens51.solveNQueens(4);
    }

    List<List<String>> res = new ArrayList<>();
    List<String> queensList = new ArrayList<>();
    int queenSize;
    public List<List<String>> solveNQueens(int n) {
        boolean[][] queens = new boolean[n][n];
        queenSize = n;
        backtracking(queens, 0, 0);
        return res;
    }

    private void backtracking(boolean[][] queens, int rowIndex, int lineIndex) {
        if (queensList.size() == queenSize) {
            res.add(new ArrayList<>(queensList));
            return;
        }

        for (int i = 0; i < queenSize; i++) {
            if (okArea(queens, rowIndex, i)) {
                queens[rowIndex][i] = true;
                String queenArea = queenArea(i);
                queensList.add(queenArea);
                backtracking(queens, rowIndex + 1, lineIndex);
                queensList.remove(queensList.size() - 1);
                queens[rowIndex][i] = false;
            }
        }
    }

    private String queenArea(int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < queenSize; j++) {
            if (i == j) sb.append('Q');
            else sb.append('.');
        }
        return sb.toString();
    }

    private boolean okArea(boolean[][] queens, int rowIndex, int lineIndex) {
        // 检查行是否有Queen
//        for (int i = 0; i < queenSize; i++) {
//            if (queens[rowIndex][i]) return false;
//        }
        // 检查列是否有Queen
        for (int i = 0; i < queenSize; i++) {
            if (queens[i][lineIndex]) return false;
        }
        // 检查45度是否有Queen
        int row = rowIndex, line = lineIndex;
        while (row >= 0 && row < queenSize && line >=0 && line < queenSize) {
            if (queens[row][line]) return false;
            row--; line--;
        }
//        row = rowIndex; line = lineIndex;
//        while (row >= 0 && row < queenSize && line >=0 && line < queenSize) {
//            if (queens[row][line]) return false;
//            row++; line++;
//        }
        // 检查135度是否有Queen
        row = rowIndex; line = lineIndex;
        while (row >= 0 && row < queenSize && line >=0 && line < queenSize) {
            if (queens[row][line]) return false;
            row--; line++;
        }
//        row = rowIndex; line = lineIndex;
//        while (row >= 0 && row < queenSize && line >=0 && line < queenSize) {
//            if (queens[row][line]) return false;
//            row++; line--;
//        }
        return true;
        // 哦 后边补充, 其实不用检查行和斜右下方的和同一行的  因为每次递归都会往下走
    }
}

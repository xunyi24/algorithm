package leetcode;

public class SolveSudoku37 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new SolveSudoku37().solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        backtracking(board, 0, 0);
    }
    
    private boolean backtracking(char[][] board, int rowIndex, int lineIndex) {
        for (int i = rowIndex; i < 9; i++) {
            lineIndex = 0;
            for (int j = lineIndex; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (isOkArea(board, i, j, k)) {
                        board[i][j] = k;
                        if (backtracking(board, i, j + 1)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isOkArea(char[][] board, int rowIndex, int lineIndex, char number) {
        // 判断行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[rowIndex][i] == number) return false;
        }
        // 判断列是否重复
        for (int i = 0; i < 9; i++) {
            if (board[i][lineIndex] == number) return false;
        }
        // 判断九宫格是否重复
        int startRow = (rowIndex / 3) * 3;
        int startCol = (lineIndex / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) { // 判断9方格里是否重复
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}

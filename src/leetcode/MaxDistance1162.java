package leetcode;

public class MaxDistance1162 {
    public int maxDistance(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, maxDistance(grid, i, j));
                }
            }
        }

        return res;
    }

    public int maxDistance(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            return 0;
        }
        if (grid[i][j] != 0) {
            return 0;
        }

        //上下左右
        maxDistance(grid, i, j - 1);
        maxDistance(grid, i, j + 1);
        maxDistance(grid, i - 1, j);
        maxDistance(grid, i + 1, j);

        return 1;
    }

    public boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid[0].length && j >= 0 && j < grid.length;
    }
}

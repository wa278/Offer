/*
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
每一次只能向左，右，上，下四个方向移动一格，
但是不能进入行坐标和列坐标的数位之和大于k的格子。
 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Solution65 {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];

        return movingCount(threshold, 0, 0, rows, cols, flag);
    }

    public int movingCount(int threshold, int i, int j, int rows, int cols, boolean[][] flag) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return 0;
        }
        if (flag[i][j]) {
            return 0;
        }
        if (canIn(threshold, i, j, rows, cols)) {
            flag[i][j] = true;
            return 1 + movingCount(threshold, i + 1, j, rows, cols, flag) +
                    movingCount(threshold, i - 1, j, rows, cols, flag) +
                    movingCount(threshold, i, j + 1, rows, cols, flag) +
                    movingCount(threshold, i - 1, j, rows, cols, flag);
        } else {
            return 0;
        }

    }

    public boolean canIn(int threshold, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        int k = 0;
        while (row / 10 != 0) {
            k = k + row % 10;
            row = row / 10;
        }
        k = k + row;
        while (col / 10 != 0) {
            k = k + col % 10;
            col = col / 10;
        }
        k = k + col;
        return threshold >= k;
    }

    public static void main(String[] args) {
        Solution65 x = new Solution65();
        x.movingCount(5, 10, 10);
    }
}

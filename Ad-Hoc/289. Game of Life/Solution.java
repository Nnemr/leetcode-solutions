class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public boolean isAlive(int row, int col, int[][] board) {
        int liveCells = 0;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValid(newRow, newCol, board.length, board[0].length)) {
                liveCells += (board[newRow][newCol]);
            }
        }

        System.out.println(row + " " + col + " " + board[row][col] + " " + liveCells);
        if (board[row][col] == 0) {
            //System.out.println(liveCells + " " + (liveCells == 3));
            return (liveCells == 3);
        } else {
            //System.out.println(liveCells + " " + (liveCells == 3 || liveCells == 2));
            return (liveCells == 3 || liveCells == 2);
        }

    }

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] result = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int val = isAlive(i, j, board) ? 1 : 0;
                result[i][j] = val;
                System.out.println(i + " " + j + " " + val);
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                board[i][j] = result[i][j];
            }
        }
    }
}
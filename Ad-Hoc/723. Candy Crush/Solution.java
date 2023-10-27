class Solution {
    public int[][] candyCrush(int[][] board) {
        int N = board.length, M = board[0].length;
        boolean crushed = true;
        while (crushed) {
            crushed = false;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    int value = Math.abs(board[i][j]);
                    if (value == 0) {
                        continue;
                    }
                    if (j < M - 2 && Math.abs(board[i][j + 2]) == value && Math.abs(board[i][j + 1]) == value) {
                        crushed = true;
                        int column = j;
                        while (column < M && Math.abs(board[i][column]) == value) {
                            board[i][column++] = -value;
                        }
                    }

                    if (i < N - 2 && Math.abs(board[i + 2][j]) == value && Math.abs(board[i + 1][j]) == value) {
                        crushed = true;
                        int row = i;
                        while (row < N && Math.abs(board[row][j]) == value) {
                            board[row++][j] = - value;
                        }
                    }
                    
                }
            }

            if (crushed) {
                for (int j = 0; j < M; ++j) {
                    int newRow = N - 1;
                    for (int i = N - 1; i > -1; --i) {
                        if (board[i][j] > 0) {
                            board[newRow--][j] = board[i][j];
                        }
                    }

                    for (int i = newRow; i > -1; --i) {
                        board[i][j] = 0;
                    }
                }
            }
        }
        return board;
    }
}
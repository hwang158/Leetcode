/**
 * idea is only judge the current row or col or 2 diagonals whether the sum is n
 * complexity is O(1)
 */
class TicTacToe {
    private int number;
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiag;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        number = n;
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }
        if (col + row + 1 == number) {
            antiDiag += toAdd;
        }
        if (Math.abs(rows[row]) == number || Math.abs(cols[col]) == number ||
            Math.abs(diagonal) == number || Math.abs(antiDiag) == number) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
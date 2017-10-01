class Solution {
    public int countBattleships(char[][] board) {
        //corner case
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }

        //check each slot one time and count add only first time encounter the ship
        //i.e. first encounter means no previous slot is "X"
        //be careful with i = 0 j= 0
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    count++;
                }
            }
        }
        return count;
    }
}
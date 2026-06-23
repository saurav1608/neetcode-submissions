class Solution {
    public void solve(char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;

        //Convert every border region and connected regions so that it can never be captured
        for (int i=0; i<rowLen;i++) {
            for (int j=0; j<colLen;j++) {
                if (isCellABorder(i,j,rowLen,colLen) && board[i][j] == 'O') {
                    temporarilyCaptureCells(board, i, j, rowLen, colLen);
                }  
            }
        }

        //Capture remaining areas
        for (int i=0; i<rowLen;i++) {
            for (int j=0; j<colLen; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        //Uncapture temporarily captured areas
        for (int i=0; i<rowLen;i++) {
            for (int j=0; j<colLen; j++) {
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }    
    }

    public void temporarilyCaptureCells(char[][] board, int x, int y, int rowLen, int colLen) {
        if (x>=rowLen ||
        y>=colLen ||
        x<0 ||
        y<0 || 
        board[x][y] != 'O') return;
        board[x][y] = 'T';
        temporarilyCaptureCells(board, x+1, y, rowLen, colLen);
        temporarilyCaptureCells(board, x-1, y, rowLen, colLen);
        temporarilyCaptureCells(board, x, y+1, rowLen, colLen);
        temporarilyCaptureCells(board, x, y-1, rowLen, colLen);
    }

    public boolean isCellABorder(int x, int y, int rowLen, int colLen) {
        if (x==0 || x==rowLen-1 || y==0 || y == colLen-1) return true;
        else return false;
    }
}

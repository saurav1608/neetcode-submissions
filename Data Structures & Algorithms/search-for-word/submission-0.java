class Solution {
    private boolean[][] visitedGrid;
    public boolean exist(char[][] board, String word) {
        visitedGrid = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (canFindWord(r, c, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean canFindWord(int r, int c, int index, String word, char[][] board) {
        //if index reaches the length of the word, the word is found
        if (index == word.length()) {
            return true;
        }

        /*If,
        rows and columns out of bounds
        or current character not equal to the character to be searched
        or the character previously visited
        return false
        */
        if (r < 0 || c < 0 ||
        r >= board.length || c >= board[0].length ||
        visitedGrid[r][c] == true || 
        word.charAt(index) != board[r][c]) return false;

        //if none of the above conditions matched, the path is okay
        visitedGrid[r][c] = true;

        //traverse in all directions for the next character
        boolean res = canFindWord(r+1, c, index+1, word, board) ||
        canFindWord(r-1, c, index+1, word, board) ||
        canFindWord(r, c+1, index+1, word, board) || 
        canFindWord(r, c-1, index+1, word, board);
        visitedGrid[r][c] = false;
        return res;
    }
}

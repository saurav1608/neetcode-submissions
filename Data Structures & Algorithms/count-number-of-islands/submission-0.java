class Solution {
    public int numIslands(char[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int res = 0;
        for (int i = 0; i<rowLength;i++) {
            for (int j=0; j<colLength; j++) {
                if (grid[i][j] == '1') {
                    convertNeighboursToSeen(grid, i, j, rowLength, colLength);
                    res +=1;
                }
            }
        }
        return res;
    }

    public void convertNeighboursToSeen(char[][] grid, int i, int j, int rowLength, int colLength) {
        if (i >= rowLength ||
        j >= colLength ||
        i<0 ||
        j<0||
        grid[i][j] == '0') return;

        grid[i][j] = '0';
        convertNeighboursToSeen(grid, i + 1, j, rowLength, colLength);
        convertNeighboursToSeen(grid, i - 1, j, rowLength, colLength);
        convertNeighboursToSeen(grid, i, j + 1, rowLength, colLength);
        convertNeighboursToSeen(grid, i, j - 1, rowLength, colLength);
    }
}

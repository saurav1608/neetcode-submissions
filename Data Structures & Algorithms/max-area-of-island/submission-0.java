class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int maxArea = 0;
        for(int i=0;i<rowLen;i++) {
            for (int j=0;j<colLen;j++) {
                if (grid[i][j] == 1) {
                    int area = findAreadOfConnectedRegions(grid, i, j, rowLen, colLen);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int findAreadOfConnectedRegions(int[][] grid, int x, int y, int rowLen, int colLen) {
        if (x>=rowLen ||
        y>=colLen ||
        x<0 ||
        y<0||
        grid[x][y]==0) return 0;
        grid[x][y] = 0;
        return findAreadOfConnectedRegions(grid, x+1, y, rowLen, colLen) +
        findAreadOfConnectedRegions(grid, x-1, y, rowLen, colLen) +
        findAreadOfConnectedRegions(grid, x, y+1, rowLen, colLen) +
        findAreadOfConnectedRegions(grid, x, y-1, rowLen, colLen) + 1;
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        return minPathSumInPlace(grid);
    }

    public int minPathSumUsingMatrix(int[][] grid) {
        int[][] dpGrid = new int[grid.length][grid[0].length];
        dpGrid[0][0] = grid[0][0];
        for (int row = 0; row < grid.length; row++){
            for(int col=0; col < grid[0].length; col++) {
                if (row == 0 && col == 0) continue;
                int left = (col-1 < 0) ? Integer.MAX_VALUE : dpGrid[row][col-1];
                int up = (row - 1 < 0) ? Integer.MAX_VALUE : dpGrid[row-1][col];
                dpGrid[row][col] = grid[row][col] + Math.min(left, up);
            }
        }
        return dpGrid[grid.length - 1][grid[0].length - 1];
    }

        public int minPathSumInPlace(int[][] grid) {
    
        for (int row = 0; row < grid.length; row++){
            for(int col=0; col < grid[0].length; col++) {
                if (row == 0 && col == 0) continue;
                int left = (col-1 < 0) ? Integer.MAX_VALUE : grid[row][col-1];
                int up = (row - 1 < 0) ? Integer.MAX_VALUE : grid[row-1][col];
                grid[row][col] = grid[row][col] + Math.min(left, up);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
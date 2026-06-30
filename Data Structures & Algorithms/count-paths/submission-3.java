class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathsUsingMatrix(m, n);   
    }

    public int uniquePathsUsingArrays(int m, int n) {
        //If there is only one row or column, there is alwaws one way to reach the end
        if (m==1 || n==1) {
            return 1;
        }

        int[] prevRow = new int[n];
        Arrays.fill(prevRow, 1);
       
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                prevRow[col] = prevRow[col-1] + prevRow[col];
            }
        }
        return prevRow[n-1];
    }

    public int uniquePathsUsingMatrix(int m, int n) {
        int[][] grid = new int[m][n];
        //populate first row with ones
        for (int col = 0; col<n;col++) {
            grid[0][col] = 1;
        }

        //populate first col with ones
        for (int row = 0; row<m;row++) {
            grid[row][0] = 1;
        }

        //populate the grid
        for (int row = 1; row < m; row++) {
            for(int col = 1; col < n; col++) {
                grid[row][col] = grid[row-1][col] + grid[row][col-1];
            }
        }

        //return the value at grid[m-1][j-1] (the end point)
        return grid[m-1][n-1];
    }
}

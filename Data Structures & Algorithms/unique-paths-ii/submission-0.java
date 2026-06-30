class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsUsingMatrix(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
    }

    public int uniquePathsUsingMatrix(int[][] obstacleGrid, int row, int col) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1) {
            return 0;
        }

        int pathMatrix[][] = new int[row][col];

        //populate the first row
        for (int c = 0; c < col; c++) {
            if (obstacleGrid[0][c] == 1) {
                break;
            }
            pathMatrix[0][c] = 1;
        }

        //populate the first column
        for (int r = 0; r < row; r++) {
            if (obstacleGrid[r][0] == 1) {
                break;
            }
            pathMatrix[r][0] = 1;
        }

        //start populating the grid
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if (obstacleGrid[r][c] == 1) {
                    pathMatrix[r][c] = 0;
                } else {
                    pathMatrix[r][c] = pathMatrix[r-1][c] + pathMatrix[r][c-1];
                }
            }
        }
        return pathMatrix[row-1][col-1];
    }
}
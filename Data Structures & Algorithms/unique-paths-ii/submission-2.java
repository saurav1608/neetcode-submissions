class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsInPlace(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
    }

    public int uniquePathsInPlace(int[][] obstacleGrid, int row, int col) {    
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r==0 && c==0) continue;
                if(obstacleGrid[r][c] == 1) {
                    obstacleGrid[r][c] = 0;
                } else {
                    int up = (r-1 < 0) ? 0 : obstacleGrid[r-1][c];
                    int left = (c-1 < 0) ? 0 : obstacleGrid[r][c-1]; 
                    obstacleGrid[r][c] = up + left;
                }
            }
        }
        return obstacleGrid[row-1][col-1];
    }

    public int uniquePathsUsingArrays(int[][] obstacleGrid, int row, int col) {
        int[] prevRow = new int[col];
        //populate the previous row for first row
        for (int c = 0; c < col ; c++) {
            if (obstacleGrid[0][c] == 1) {
                break;
            }
            prevRow[c] = 1;
        }

        //Start iterating for every other row
        for (int r = 1; r < row; r++) {
            prevRow[0] = (obstacleGrid[r][0] == 1) ? 0 : prevRow[0]; 
            for (int c = 1; c < col; c++) {
                if (obstacleGrid[r][c] == 1) {
                    prevRow[c] = 0;
                } else {
                    prevRow[c] += prevRow[c-1];
                }
            }
        }

        return prevRow[col-1];
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
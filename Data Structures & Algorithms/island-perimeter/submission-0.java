class Solution {
    public int islandPerimeter(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] visited = new int[rowLength][colLength];
        for (int i=0; i<rowLength; i++) {
            for (int j=0; j<colLength;j++) {
                if (grid[i][j] == 1) {
                    return traverseGridToFindPerimeter(visited, grid, i, j, rowLength, colLength);
                }
            }
        }
        return 0;        
    }

    public int traverseGridToFindPerimeter(int[][] visited, int[][] grid, int i, int j, int rowLength, int colLength) {
        if (i >= rowLength ||
        j >= colLength || 
        i<0 ||
        j < 0 ||
        grid[i][j] == 0) return 1;

        if (visited[i][j] == 1) return 0;

        visited[i][j] = 1;
        int perimeter = 0;
        perimeter += traverseGridToFindPerimeter(visited, grid, i + 1, j, rowLength, colLength);
        perimeter += traverseGridToFindPerimeter(visited, grid, i - 1, j, rowLength, colLength);
        perimeter += traverseGridToFindPerimeter(visited, grid, i, j + 1, rowLength, colLength);
        perimeter += traverseGridToFindPerimeter(visited, grid, i, j - 1, rowLength, colLength);
        return perimeter;
    }
}
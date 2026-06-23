class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[rowLen][colLen];
        
        //Add zeroes to the queue
        for (int i = 0; i < rowLen; i++) {
            for (int j=0; j < colLen; j++) {
                if (grid[i][j]== 0) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = 1;
                }
            }
        }
        
        int dist = 0;
        // Add distance to the grid for surrounding elements
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c=cell[1];
                grid[r][c] = dist;
                addCellToGrid(queue, grid, visited, r+1, c, rowLen, colLen);
                addCellToGrid(queue, grid, visited, r-1, c, rowLen, colLen);
                addCellToGrid(queue, grid, visited, r, c+1, rowLen, colLen);
                addCellToGrid(queue, grid, visited, r,  c-1, rowLen, colLen);
                
            }
            dist++;
        }        
    }

    public void addCellToGrid(Queue<int[]> queue, int[][] grid, int[][] visited,  int r, int c, int rowLen, int colLen) {
        if (r>=rowLen || 
        c>=colLen || 
        r<0 ||
        c<0 ||
        visited[r][c] == 1 ||
        grid[r][c] == -1) {
            return;
        }
        visited[r][c] = 1;
        queue.offer(new int[]{r,c});
    }
}

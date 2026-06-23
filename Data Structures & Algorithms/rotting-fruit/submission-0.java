class Solution {
    public int orangesRotting(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        Queue<int[]> queue= new LinkedList();
        int fresh = 0;

        //Calculate no of fresh fruits at t=0 and push rotten fruits to queue  
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (grid[r][c] == 1) fresh++;
                if (grid[r][c] == 2){
                    queue.offer(new int[]{r,c});
                }
            }
        }

        int time = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size;i++) {
                int[] rottenFruit = queue.poll();
                int xRotten = rottenFruit[0];
                int yRotten = rottenFruit[1];
                grid[xRotten][yRotten] = 2;

                for (int[] dir : directions) {
                    int row = xRotten + dir[0];
                    int col = yRotten + dir[1];
                    if (row >= 0 && row < rowLen &&
                    col >=0 && col < colLen && 
                    grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return (fresh==0) ? time : -1;        
    }
}

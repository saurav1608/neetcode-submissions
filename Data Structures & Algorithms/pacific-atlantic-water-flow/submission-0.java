class Solution {
    
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowLen = heights.length;
        int colLen = heights[0].length;
        int[][] pacificVisit = new int[rowLen][colLen];
        int[][] atlanticVisit = new int[rowLen][colLen];

        //Start traversal from first and last row
        for (int c = 0; c < colLen;c++) {
            populateVisitedArray(heights, 0, c, pacificVisit, rowLen, colLen, heights[0][c]);
            populateVisitedArray(heights, rowLen-1, c, atlanticVisit, rowLen, colLen, heights[rowLen-1][c]);
        } 

        //Start traversal from first and last column
        for (int r = 0; r < rowLen; r++) {
            populateVisitedArray(heights, r, 0, pacificVisit, rowLen, colLen, heights[r][0]);
            populateVisitedArray(heights, r, colLen-1, atlanticVisit, rowLen, colLen, heights[r][colLen-1]);
        } 

        List<List<Integer>> commonFlows = new ArrayList();
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (pacificVisit[r][c] == 1 && atlanticVisit[r][c] == 1) {
                    List<Integer> coord = new ArrayList<>();
                    coord.add(r);
                    coord.add(c);
                    commonFlows.add(coord);
                }
            }
        }
        return commonFlows;
    }

    public void populateVisitedArray(int[][] heights, int r, int c, int[][] visited, int rowLen, int colLen, int prevHeight) {
        if (r < 0 ||
        c < 0 ||
        r >= rowLen||
        c >= colLen ||
        visited[r][c] == 1 ||
        heights[r][c] < prevHeight) return;

        visited[r][c] = 1;
        for (int dir[] : directions) {
            int dr = r + dir[0];
            int dc = c + dir[1];
            populateVisitedArray(heights, dr, dc, visited, rowLen, colLen, heights[r][c]);
        }
    }
}

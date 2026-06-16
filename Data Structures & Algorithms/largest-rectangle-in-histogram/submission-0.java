class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> indexHeightPair = new Stack();
        for (int i=0;i<heights.length;i++) {
            int start = i;
            while(!indexHeightPair.isEmpty() && indexHeightPair.peek()[1] > heights[i]) {
                int[] heightIndex = indexHeightPair.pop();
                maxArea = Math.max(maxArea, heightIndex[1]*(i-heightIndex[0]));
                start = heightIndex[0];
            }
            indexHeightPair.push(new int[]{start, heights[i]});
        }

        while(!indexHeightPair.isEmpty()) {
            int[] heightIndex = indexHeightPair.pop();
             maxArea = Math.max(maxArea, heightIndex[1]*(heights.length-heightIndex[0]));
        }

        return maxArea;
        
    }
}

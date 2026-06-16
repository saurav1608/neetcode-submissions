class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;
        int start = 0, end = heights.length-1;
        while (start < end) {
            ans = Math.max(Math.min(heights[start], heights[end])*(end-start), ans);
            if (heights[start] > heights[end]) {
                end --;
            } else {
                start ++;
            }
        }
        
        return ans;
        
    }
}

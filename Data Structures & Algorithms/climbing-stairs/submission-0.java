class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n==0) {
            return n;
        }

        int [] ans = new int[n+1];
        ans[0] = 1; 
        ans[1] = 1;
        for (int i=2; i<ans.length; i++) {
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[ans.length-1];
    }
}

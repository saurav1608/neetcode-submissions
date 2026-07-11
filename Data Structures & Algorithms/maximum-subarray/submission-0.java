class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubUsingDp(nums);
    }

    public int maxSubUsingDp(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(
                nums[i],
                nums[i] + dp[i-1]
            );
        }

        int result = dp[0];
        for (int i=0; i<nums.length; i++) {
            result = Math.max(
                result, 
                dp[i]
            );
        }
        return result;
    }
}

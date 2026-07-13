class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int subArraySum = 0;
        int result = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            subArraySum += nums[r];
            while (subArraySum >= target) {
                result = Math.min(result, r - l + 1);
                subArraySum -= nums[l++];     
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
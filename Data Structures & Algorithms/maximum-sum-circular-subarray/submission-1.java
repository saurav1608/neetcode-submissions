class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        return maxCircularSum(nums);
    }

    public int maxCircularSum(int[] nums) {
        int currMax = 0, currMin = 0;
        int globalMax = nums[0], globalMin = nums[0];
        int total = 0;
        for (int n : nums) {
            total += n;
            currMax = Math.max(n, n + currMax);
            currMin = Math.min(n, n + currMin);
            globalMax = Math.max(globalMax, currMax);
            globalMin = Math.min(globalMin, currMin);
        }
        if (globalMax < 0) {
            return globalMax;
        } else {
            return Math.max(globalMax, total - globalMin);
        }
    }
}
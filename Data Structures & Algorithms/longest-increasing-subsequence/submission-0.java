class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tabulation = new int[nums.length];
        Arrays.fill(tabulation, 1);
        return tabulationOptimizationLongestSubsequence(nums, tabulation);

        //return recurseToFindLongestSubsequence(0, -1, nums);
        
    }

    public int tabulationOptimizationLongestSubsequence(int[] nums, int[] tabulation) {
        for (int i=tabulation.length-1;i >= 0;i--) {
            for (int j = i+1; j < tabulation.length; j++) {
                if (nums[j] > nums[i]) {
                    tabulation[i] = Math.max(
                        tabulation[i],
                        1+tabulation[j]
                    );
                }
            }
        }

        int max = 1;
        for (int i = 0; i<tabulation.length;i++) {
            max = Math.max(max, tabulation[i]);
        }
        return max;  
    }

    public int recurseToFindLongestSubsequence(int index, int prevLargestIndex, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        //Find the longest subsequence not including this character
        int longestSubsequence = recurseToFindLongestSubsequence(index+1, prevLargestIndex, nums);

        //Find the longest subsequence including the current character
        if (prevLargestIndex == -1 || nums[prevLargestIndex] < nums[index]) {
            longestSubsequence = Math.max(
                longestSubsequence, 
                1 + recurseToFindLongestSubsequence(index+1, index, nums)
            );
        }
        return longestSubsequence;

    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        return checkPrefixSumForEquality(nums, k);
    }

    public int checkPrefixSumForEquality(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCountMap = new HashMap();
        //Initialize map if the current subarray actually equals k
        prefixSumCountMap.put(0, 1);
        int res = 0;
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            /*
            Check the map if a previous subarray can be removed which can make the sum = k
            This is done by maintaining a prefix map and looking for runningSum - k
            */
            res += prefixSumCountMap.getOrDefault(runningSum-k,0);
            prefixSumCountMap.put(runningSum, prefixSumCountMap.getOrDefault(runningSum,0)+1);
        }
        return res;
    }

    public int checkEverySubarrayForEquality(int[] nums, int k) {
        int res = 0;
        for (int i=0; i<nums.length;i++) {
            int runningSum = 0;
            for (int j=i;j<nums.length;j++) {
                runningSum += nums[j];
                if (runningSum == k) res+=1;
            }
        }
        return res;
    }
}
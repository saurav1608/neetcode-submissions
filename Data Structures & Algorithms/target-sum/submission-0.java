class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //Create a memoization matrix
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        //The table should have rows corresponding to index and columsn corresponding to possible sums from -totalSum to totalSum
        int[][] memo = new int[nums.length][2*totalSum + 1];

        //Populate memo matrix with some value < 0
        for (int i = 0; i<memo.length;i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        }

        return traverseToFindTargetWithMemo(0, 0, target, totalSum, nums, memo);
    }

    public int traverseToFindTarget(int i, int sum, int target, int[] nums) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return traverseToFindTarget(i+1, sum + nums[i], target, nums) + traverseToFindTarget(i+1, sum - nums[i], target, nums);
    }

    public int traverseToFindTargetWithMemo(int i, int sum, int target, int totalSum, int[] nums, int[][] memo) {
        //Base case where i reaches out of limit
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        //Case where (i,sum) is in the memo matrix i.e a previous value is found
        if (memo[i][sum+totalSum] != Integer.MIN_VALUE) {
            return memo[i][sum+totalSum];
        }

        //Populate the memo matrix with value after doing a recursive call
        memo[i][sum + totalSum] = traverseToFindTargetWithMemo(i+1, sum + nums[i], target, totalSum, nums, memo) + traverseToFindTargetWithMemo(i+1, sum - nums[i], target, totalSum, nums, memo);  
        return memo[i][sum+totalSum];
    }
}

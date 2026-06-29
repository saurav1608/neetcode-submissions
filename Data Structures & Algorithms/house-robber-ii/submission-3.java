class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(
            moneyRobbingHouses(0, nums.length-1,nums), 
            moneyRobbingHouses(1, nums.length, nums)
        );
    }

    public int moneyRobbingHouses(int start, int end, int[] nums) {
        int avoidRobbingPrevious = 0;
        int robPrevious = 0;
        int cost = 0;
        for (int i = start; i< end; i++) {
            cost = Math.max(avoidRobbingPrevious + nums[i], robPrevious);
            avoidRobbingPrevious = robPrevious;
            robPrevious = cost;
        }
        return cost;
    }
}

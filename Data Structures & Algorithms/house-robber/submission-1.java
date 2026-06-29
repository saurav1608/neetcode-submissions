class Solution {
    public int rob(int[] nums) {
        int skipRobbingLastHouse = 0;
        int robLastHouse = nums[0];
        int costOfRobbingCurrentHouse = 0;
        if (nums.length == 1) {
            return nums[0];
        }
        for(int i=1;i<nums.length;i++) {
            costOfRobbingCurrentHouse = Math.max(robLastHouse, skipRobbingLastHouse + nums[i]);
            skipRobbingLastHouse = robLastHouse;
            robLastHouse = costOfRobbingCurrentHouse;
        }
        return costOfRobbingCurrentHouse;
        
    }
}

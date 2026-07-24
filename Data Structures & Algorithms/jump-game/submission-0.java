class Solution {
    public boolean canJump(int[] nums) {
        // HashMap<Integer, Boolean> jumpMemo = new HashMap<>();
        // return canJumpFromIndex(nums, 0, jumpMemo);
        return canJumpToTargetGreedy(nums);
    }

    public boolean canJumpFromIndex(int[] nums, int index, HashMap<Integer, Boolean> jumpMemo) {
        if (jumpMemo.containsKey(index)) return jumpMemo.get(index);
        if (index == nums.length - 1) return true;
        if (index >= nums.length) return false;
        if (nums[index] == 0) return false;

        for (int i = 1; i<=nums[index]; i++) {
            if (canJumpFromIndex(nums, index + i, jumpMemo)){
                jumpMemo.put(index, true);
                return true;
            }
        } 
        jumpMemo.put(index, false);
        return false;
    }

    public boolean canJumpToTargetGreedy(int[] nums) {
        int targetToReach = nums.length -1;
        for (int i = nums.length-1; i>=0; i--) {
            if (nums[i] + i >= targetToReach) {
                targetToReach = i;
            }
        }
        return targetToReach == 0;
    }
}

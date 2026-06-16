class Solution {
    public int removeDuplicates(int[] nums) {
        int placementPointer = 0;
        Set<Integer> set = new HashSet();
        for (int i=0; i<nums.length;i++) {
            if (!set.contains(nums[i])) {
                nums[placementPointer] = nums[i];
                placementPointer++;
                set.add(nums[i]);
            }
        }
        return placementPointer;
        
    }
}
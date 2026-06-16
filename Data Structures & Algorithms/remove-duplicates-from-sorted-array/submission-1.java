class Solution {
    public int removeDuplicates(int[] nums) {
        return removeUsingSortProperties(nums);
        
    }

    public int removeUsingSortProperties(int[] nums) {
        int placementPointer = 1;
        for (int i=1; i<nums.length;i++) {
            if (nums[i] != nums[i-1]) {
                nums[placementPointer++] = nums[i];
            }
        }
        return placementPointer;
    }

    public int removeUsingSet(int[] nums) {
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
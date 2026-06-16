class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                start++;
            }
        }
        return start;
        
    }
}
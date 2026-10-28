class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;
        int pointer = 0;
        while (pointer <= end) {
            if (nums[pointer]==0) {
                int temp = nums[start];
                nums[start] = nums[pointer];
                nums[pointer] = temp;
                start++;

            } else if (nums[pointer] == 2) {
                int temp = nums[end];
                nums[end] = nums[pointer];
                nums[pointer] = temp;
                end--;
                pointer--;
            } 
                pointer++;
            }
        }     
    }
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        //rotate the entire array
        int start = 0,  end = len-1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        //rotate the right slice
        start = 0; end = k-1;
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        //rotate the left slice
        start = k; end = nums.length - 1;
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }  
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //initialize prefix and suffix products
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;
        //initialize prefix product array
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        //initialize suffix product array
        for (int i=nums.length-2; i>=0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        //calculate the final answer
        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
        
    }
}  

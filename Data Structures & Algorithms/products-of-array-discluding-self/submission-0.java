class Solution {
    public int[] productExceptSelf(int[] nums) {
                int[] result = new int[nums.length];
        int [] prefixProduct = new int[nums.length];   
        int [] suffixProduct = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixProduct[i] = i == 0 ? nums[i] : prefixProduct[i - 1] * nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixProduct[i] = i == nums.length - 1 ? nums[i] : suffixProduct[i + 1] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int left = i == 0 ? 1 : prefixProduct[i - 1];
            int right = i == nums.length - 1 ? 1 : suffixProduct[i + 1];
            result[i] = left * right;
        }
        return result;
    }

}  

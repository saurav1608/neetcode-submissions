class Solution {
    public int firstMissingPositive(int[] nums) {
        return findMissingPositiveInPlace(nums);
    }

    public int findMissingPositiveInPlace(int[] nums) {
        int length = nums.length;
        //In the first pass, convert all -ve integers to 0
        for (int i=0; i< length; i++ ) {
            if (nums[i] < 0) nums[i] = 0;
        }

        //In the second pass, if the positive integer exists within range, mark it in the array
        for (int i=0;i<length;i++) {
            int insertionIndex = Math.abs(nums[i]);
            if (insertionIndex >= 1 && insertionIndex <= length) {
                if (nums[insertionIndex - 1] == 0) nums[insertionIndex-1] = -(length+1);
                else if (nums[insertionIndex-1] > 0) nums[insertionIndex-1] = -nums[insertionIndex-1]; 
            }
        }

        //The missing positive is bound by range 1 .. lengthOfArray + 1. If in array, the number at a given index is positive, it is missing
        for(int i=1; i<=length;i++) {
            if (nums[i-1] >= 0) return i;
        }
        return length+1;

    }
}
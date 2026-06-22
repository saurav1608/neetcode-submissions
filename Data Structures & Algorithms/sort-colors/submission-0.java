class Solution {
    public void sortColors(int[] nums) {
        int zeroPointer = 0;
        int twoPointer = nums.length - 1;
        int trackingPointer = 0;
        while (trackingPointer <= twoPointer) {
            //Place zeroes at the beginning
            if (nums[trackingPointer] == 0) {
                swap(nums, zeroPointer, trackingPointer);
                zeroPointer++;
            }

            //Place twos at the end
            if (nums[trackingPointer] == 2) {
                swap(nums, trackingPointer, twoPointer);
                twoPointer--;
                //Decrement tracking pointer since it might swap a 0, incremented in next step to keep in place
                trackingPointer--;
                
            }
            trackingPointer++;
        }
        
    }

    public void swap(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}
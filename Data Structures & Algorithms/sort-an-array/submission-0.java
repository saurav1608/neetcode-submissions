class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length-1);
        return nums;
        
    }

    public void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int partitionIndex = getPartitionIndex(nums, low, high);
            quicksort(nums, low, partitionIndex - 1);
            quicksort(nums, partitionIndex+1, high);
        }
    }

    public int getPartitionIndex(int[] nums, int low, int high) {
        int pivot = nums[low], i=low, j=high;
        while (i < j) {
            while (nums[i] <= pivot && i < high) i++;
            while(nums[j] > pivot && j >= low+1) j--;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
        return j;
    }
}
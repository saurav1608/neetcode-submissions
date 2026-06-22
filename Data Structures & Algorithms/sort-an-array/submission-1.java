class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
        
    }

    public void mergeSort(int[] nums, int low, int high) {
        if (low == high) return;
        int mid = (low+high)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        mergeSortedArrays(nums, low, mid, high);
    }

    public void mergeSortedArrays(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }
        for (int i=low; i<=high;i++) {
            nums[i] = temp.get(i-low);
        }
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
            while(nums[j] > pivot && j > low) j--;
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
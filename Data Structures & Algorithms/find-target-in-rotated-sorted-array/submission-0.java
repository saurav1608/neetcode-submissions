class Solution {
    public int search(int[] nums, int target) {
        return binarySearchOnRotatedArray(nums, target);
    }

    public int binarySearchOnRotatedArray(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //start a binary search and go till left and right pointers don't cross
        while (left <= right) {
            //calculate mid
            int mid = left + (right - left)/2;

            //return if the midpoint is equal to target
            if (nums[mid] == target) return mid;

            //if left array is sorted, if target is greater than mid or less than left, search space moves to left of mid till end or otherwise start to mid-1
            if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) left = mid+1;
                else right = mid-1;
            } 
            //if right array is sorted, if target is less than mid or greater than nums[right], search to the left of mid or else search to the right
            else {
                if (target < nums[mid] || target > nums[right]) right = mid-1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}

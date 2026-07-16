class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            //if element found, return true
            if (nums[mid] == target) return true;

            //check if mid is in the left sorted portion
            if (nums[left] < nums[mid]) {
                //if target is higher than mid or lower than left, check to the right of mid
                if (target > nums[mid] || target < nums[left]) left = mid + 1;
                //else check to the right of mid
                else right = mid - 1;
            }
            //check if mid is in the right sorted portion
            else if (nums[left] > nums[mid]) {
                //if target is less than mid or greater than nums[right], check to the left of mid
                if (target < nums[mid] || target > nums[right]) right = mid - 1;
                //else check to the right of mid
                else left = mid + 1;
            }
            /**
            final case is if left is equal to mid
            we can't ascertain whether we are in left or right sorted portion
            e.g 3(l) 1 3(m) 3 3 3
            **/
            else {
                left ++;
            }
        }
        return false;
    }
}
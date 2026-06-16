class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int noAtMid = nums[mid];
            if (noAtMid == target) return mid;
            else if (noAtMid > target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
}

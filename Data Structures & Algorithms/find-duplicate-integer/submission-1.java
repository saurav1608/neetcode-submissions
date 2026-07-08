class Solution {
    public int findDuplicate(int[] nums) {
        return floydCycleDetection(nums);
    }

    public int floydCycleDetection(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
    }


    public int findDuplicateInArray(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index] < 0) return index;
            nums[index] *= -1;
        }
        return -1;
    }
}

class Solution {
    public boolean hasDuplicate(int[] nums) {
        return hashCheck(nums);
    }

    public boolean hashCheck(int[] nums) {
        HashSet<Integer> numberSet = new HashSet<>();
        for (int num : nums) {
            if (numberSet.contains(num)) {
                return true;
            }
            numberSet.add(num);
        }
        return false;
    }

    public boolean bruteForce(int[] nums) {
        for (int i = 0; i<nums.length - 1; i++) {
            for (int j = i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
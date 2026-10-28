class Solution {
    public int majorityElement(int[] nums) {
        return majorityUsingBoyerMoore(nums);
    }

    public int majorityUsingBoyerMoore(int[] nums) {
        int count = 0;
        int majorityElement = nums[0];
        for (int num : nums) {
            if (count == 0) {
                count+=1;
                majorityElement = num;
            } else if (num == majorityElement) count++;
            else count--;
        }
        return majorityElement;
    }

    public int majorityUsingMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        int maxResult = Integer.MIN_VALUE;
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0)+1;
            if (count > maxCount) {
                maxCount = count;
                maxResult = num;
            }
            countMap.put(num, count);
        }
        return maxResult;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        //Initialize HashSet to contain all unique elements
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int num : nums) uniqueElements.add(num);
        int maxLength = 0;
       
        

        for (int i=0;i<nums.length;i++) {
            int length = 1;
            if (!uniqueElements.contains(nums[i] -1)) {
                length = 1;
                while (uniqueElements.contains(nums[i] + length)) {
                    length++;
                }
            }

            maxLength = Math.max(maxLength, length);
        }
        return maxLength;     
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        return findLongestConsecutive(nums);
    }

    public int findLongestConsecutive(int[] nums) {
        //Convert array to set
        Set<Integer> uniqueElementSet = Arrays.stream(nums)
                         .boxed()
                         .collect(Collectors.toCollection(HashSet::new));
        int longest = 0;
        for (int num : nums) {
            if (!uniqueElementSet.contains(num-1)) {
                int count = 0;
                int start = num;
                while (uniqueElementSet.contains(start)) {
                    count++;
                    start+=1;
                }
                 longest = Math.max(longest, count);
            }
        } 
        return longest;
    }
}

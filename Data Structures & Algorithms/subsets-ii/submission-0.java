class Solution {
    List<List<Integer>> subsets = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, 0, subset);
        return subsets;
    }

    public void findSubsets(int[] nums, int index, List<Integer> subset) {
        //base case : add subset to result when index matches the length of nums
        if (index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        //Consider the current choice and move to the next choice
        subset.add(nums[index]);
        findSubsets(nums, index+1, subset);

        //Avoid the current choice and since dupes to be avoided, avoid any choice matching the current element
        subset.remove(subset.size() - 1);
        while (index+1 < nums.length && nums[1+index] == nums[index]) {
            index++;
        }
        findSubsets(nums, index+1, subset);
    }
}

class Solution {

    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> combination = new ArrayList<>();
        findCombinations(0, target, nums, combination);
        return combinations;   
    }

    public void findCombinations(int index, int target, int[] nums, List<Integer> combination) {
        //Base Case 1 : target reached
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        //Base Case 2: sum of elements has crossed target or index has gone out of bounds
        if (target < 0 || index >= nums.length) {
            return;
        }

        //Consider the current choice and backtrack
        combination.add(nums[index]);
        findCombinations(index, target - nums[index], nums, combination);

        //Skip the current choice and backtrack
        combination.remove(combination.size() - 1);
        findCombinations(index + 1, target, nums, combination);
    }
}

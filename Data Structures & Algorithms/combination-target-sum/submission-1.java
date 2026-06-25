class Solution {

    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(nums);
        findCombinationsWithPruning(nums, 0, target, combination, 0);
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

    public void findCombinationsWithPruning(int[] nums, int total, int target, List<Integer> combination, int index) {
        //base case
        if (total == target) {
            combinations.add(new ArrayList<>(combination));
        }

        for(int j=index; j<nums.length; j++) {
            //Don't consider any other choices if the sum has exceeded target, this works because the array will be sorted
            if (total + nums[j] > target) return;
            //Consider and backtrack with current choice
            combination.add(nums[j]);
            findCombinationsWithPruning(nums, total + nums[j], target, combination, j);
            //Avoid the current choice and backtrack, the next loop will take care of the backtracking
            combination.remove(combination.size() - 1);
        }
    }
}

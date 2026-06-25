class Solution {
    List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permutation = new ArrayList<>();
        findPermutations(nums, permutation);
        return permutations;
    }

    public void findPermutations(int[] nums, List<Integer> permutation) {
        //Base case - add to list if the permutation is of the required length
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        //Iterate through all choices
        for (int i=0; i<nums.length;i++) {
            //If the current element is already in permutation, skip it
            //Can use a boolean table to check instead of doing a liner scan in arraylist
            if (permutation.contains(nums[i])) continue;
            //consider the current choice
            permutation.add(nums[i]);
            findPermutations(nums, permutation);
            //avoid the current choice and head to the next choice
            permutation.remove(permutation.size()-1);
        }
    }
}

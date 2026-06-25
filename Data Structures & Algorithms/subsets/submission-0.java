class Solution {
    List<List<Integer>> subsets = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        findSubsets(0, path, nums);
        return subsets;
    }

    public void findSubsets(int index, List<Integer> path, int[] nums) {
        //base case - when index reaches out of bounds, add path to answer
        if (index == nums.length) {
            subsets.add(new ArrayList<>(path));
            return;
        }
        
        //backtrack with the choice considered
        path.add(nums[index]);
        findSubsets(index+1, path, nums);

        //backtrack with the choice not considered
        path.remove(path.size()-1);
        findSubsets(index+1, path, nums);
        }
    }


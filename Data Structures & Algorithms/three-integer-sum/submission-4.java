class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumWithPointers(nums);
    }

    public List<List<Integer>> threeSumWithPointers(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i=0; i<nums.length - 2; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            int start = i+1;
            int end = nums.length - 1;
            while(start < end) {
                if (nums[start] + nums[end] + nums[i] == 0) {
                    triplets.add(new ArrayList<>(Arrays.asList(nums[i], 
                    nums[start], nums[end])));
                    start++;
                    end--;
                    while(start < end &&nums[start] == nums[start-1]) {
                        start++;
                    }
                } else if (nums[start] + nums[end] < - nums[i]) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return triplets;
    }
}

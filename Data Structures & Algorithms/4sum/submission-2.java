class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return usingLoops(nums, target);   
    }

    public List<List<Integer>> usingLoops(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i=0; i<nums.length-3;i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            for (int j=i+1; j<nums.length-2;j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int start = j+1, end = nums.length-1;
                while(start < end) {
                    long curr_sum = (long)nums[i] + nums[j] +  nums[start] + nums[end];

                    if (curr_sum > target) end--;
                    else if(curr_sum < target) start++;
                    else {
                        answer.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[start], nums[end])));
                        start++;
                        end--;
                        while(start < end && nums[start] == nums[start-1]) start++; 
                    }
                }
            }
        }
        return answer;
    }
}
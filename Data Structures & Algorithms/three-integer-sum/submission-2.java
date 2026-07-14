class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return calculateThreeSum(nums);
    }

    public List<List<Integer>> calculateThreeSum(int[] nums) {
        //list containing the answer
        List<List<Integer>> result = new ArrayList<>();

        //Iterate over a sorted array
        Arrays.sort(nums);

        //iterate over elements from 0 to len(nums) - 2
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) break;
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                // if the three elements sum upto 0, add the numbers into the result list
                if (nums[left] + nums[right] + nums[i] == 0) {
                    result.add(new ArrayList<>(
                        List.of(nums[i], nums[left], nums[right])
                    ));
                    right -= 1;
                    int currentElementAtLeft = nums[left];
                    while (left < right && nums[left] == currentElementAtLeft) {
                        left++;
                    }
                }
                //Since arrays are sorted, if the sum of the two following elements is less than the required target, adjust the left pointer to higher number 
                else if (nums[left] + nums[right] < (- nums[i])) {
                    int currentElementAtLeft = nums[left];
                    while (left < right && nums[left] == currentElementAtLeft) {
                        left++;
                    }
                } 
                //Last case is if the sum is larger than target, adjust the right pointer to lower numbers
                else {
                    int currentElementAtRight = nums[right];
                    while (left < right && nums[right] == currentElementAtRight) {
                        right--;
                    }
                }
            }
            int currentElementAtI = nums[i];
            //move i till there is a different element
            while (i < nums.length - 2 && nums[i] == currentElementAtI) {
                i++;
            }
        }
        return result;
    }
}

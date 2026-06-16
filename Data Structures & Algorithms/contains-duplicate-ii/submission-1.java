class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return duplicateCheckInSet(nums, k);
    }

    public boolean duplicateCheckInMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i-map.get(nums[i])) <= k) {
                    return true;
                } 
            }
        map.put(nums[i], i);        
        }
        return false;
    }

    public boolean duplicateCheckInSet(int[] nums, int k) {
        //Maintain the element to be removed to resize set
        int left = 0;
        //Maintain set to check the elements within a window
        Set<Integer> set = new HashSet();
        for (int right = 0; right<nums.length;right++) {
            //if the window size has gone beyond k, resize the set
            if (right-left > k) {
                set.remove(nums[left]);
                left++;
            }
            if (set.contains(nums[right])) {
                return true;
            }
            set.add(nums[right]);

        }
        return false;

    }
}
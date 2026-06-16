class Solution {
    public int majorityElement(int[] nums) {
        //boyer-moore voting algo
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0) res = num;
            count += (num == res ? 1 : -1); 
        }
        return res;
        
    }
}
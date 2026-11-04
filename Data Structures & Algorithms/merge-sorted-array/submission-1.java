class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertion = nums1.length - 1;
        int pointer1 = m-1;
        int pointer2 = n-1;
        while (pointer1 >=0 || pointer2>= 0) {
            if (pointer1 >=0 && pointer2 >= 0) {
                if (nums1[pointer1] > nums2[pointer2]) {
                    nums1[insertion--] = nums1[pointer1--];
                } else {
                    nums1[insertion--] = nums2[pointer2--];
                }
            } else if (pointer1 < 0) {
                nums1[insertion--] = nums2[pointer2--];
            } else {
                nums1[insertion--] = nums1[pointer1--];
            }
        }
    }
}
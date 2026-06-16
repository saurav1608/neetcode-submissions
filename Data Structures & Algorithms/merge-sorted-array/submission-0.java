class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mTraversal = m-1;
        int nTraversal = n-1;
        int placementPointer = m+n-1;
        while (mTraversal >= 0 && nTraversal >= 0) {
            if (nums1[mTraversal] > nums2[nTraversal]) {
                nums1[placementPointer] = nums1[mTraversal];
                mTraversal--;
            } else {
                nums1[placementPointer] = nums2[nTraversal];
                nTraversal--; 
            }
            placementPointer--;
        }

        while(nTraversal >= 0) {
            nums1[placementPointer] = nums2[nTraversal]; 
            nTraversal--;
            placementPointer--; 
        } 
    }
}
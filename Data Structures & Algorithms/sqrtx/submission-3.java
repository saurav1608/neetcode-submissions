class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        return sqrtBinarySearch(x);
    }

    public int sqrtBinarySearch(int x) {
        int left = 1;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right-left)/2;
            long sqr = (long)mid*mid;
            if (sqr == x) return mid;
            else if (sqr < x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return res;
    }
}
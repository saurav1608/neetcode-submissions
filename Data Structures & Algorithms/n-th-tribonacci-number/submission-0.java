class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n>=1 && n<=2) {
            return 1;
        }
        int threeDown = 0;
        int twoDown = 1, oneDown = 1;
        int nthtribo = 0;
        for (int i = 3; i<=n;i++) {
            nthtribo = threeDown + twoDown + oneDown;
            threeDown = twoDown;
            twoDown = oneDown;
            oneDown = nthtribo;

        }
        return nthtribo;
        
    }
}
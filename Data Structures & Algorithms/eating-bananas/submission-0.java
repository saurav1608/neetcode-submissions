class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int min = right;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int timeToEat = timeToEat(piles, mid);
            if (timeToEat <= h) {
                min = mid;
                right = mid - 1;
            }
            else left = mid+1;
        }
        return min;
    }

    public int timeToEat(int[] piles, int rate) {
        int timeToEat = 0;
        for (int pile : piles) {
            timeToEat+= (pile + rate -1)/rate;
        }
        return timeToEat;
    }
}

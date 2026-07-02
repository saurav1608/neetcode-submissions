class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
        // int maxScore = 0;
        // for (int pile : piles) {
        //     maxScore+=pile;
        // }
        // int aliceScore = calculateAliceScore(0, piles.length-1, piles, 0);
        // return aliceScore > (maxScore-aliceScore);
    }

    public int calculateAliceScore(int left, int right, int[] piles, int turn) {
        //Base case, no more stones to be picked
        if (left > right) {
            return 0;
        }
        // If the current turn is alice's, we add the value of either pile to the score
        int leftPile = (turn%2 == 0) ? piles[left] : 0;
        int rightPile = (turn%2 == 0) ? piles[right] : 0;
        
        //try to maximixe alice's score
        return Math.max(
            calculateAliceScore(left+1, right, piles, turn+1) + leftPile,
            calculateAliceScore(left, right-1, piles, turn+1) + rightPile
        );
    }
}
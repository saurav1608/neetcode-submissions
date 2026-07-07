class Solution {
    public boolean makesquare(int[] matchsticks) {
        int[] sides = new int[4];
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum+=matchstick;
        }
        /*Potentially matchsticks can be sorted in decreasing order
        If the starting side is greater than limit, breaks the loop immediately
        */
        if (sum%4 > 0) return false;

        //Implementing the sorting logic
        Integer[] boxed = Arrays.stream(matchsticks).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, Collections.reverseOrder());
        // convert back to int[] if needed
        matchsticks = Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();

        return canMakeSquare(0, matchsticks, sides, sum/4);
    }

    public boolean canMakeSquare(int i, int[] matchsticks, int[] sides, int limit) {
        //base case : all sides covered 
        if (i == matchsticks.length) {
            return true;
        }

        //try adding stick to all four sides and see if the ensuing result leads to a square
        for (int j=0; j<sides.length;j++) {
            //consider the option only if adding the matchstick still is below the target length
            if (sides[j] + matchsticks[i] <= limit) {
                sides[j]+=matchsticks[i];
                if (canMakeSquare(i+1, matchsticks, sides, limit)) {
                    return true;
                }
                sides[j]-=matchsticks[i];
            }
            //If placing a matchstick on an empty side doesn't lead to a result, don't bother trying to place it on other empty sides
            if (sides[j] == 0) break;
        }
        return false;
    }
}
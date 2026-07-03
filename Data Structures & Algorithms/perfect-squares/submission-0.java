class Solution {
    public int numSquares(int n) {
        //Map<Integer, Integer> map = new HashMap<>();
        return tabulateToFindSquares(n);
    }

    public int recurseToFindSquares(int target, Map<Integer, Integer> map) {
        //if number is 0, no perfect squares can match to it
        if (target == 0) {
            return 0;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int res = target;
        for (int i = 1; i*i<=target;i++) {
            res = Math.min(
                res,
                1+recurseToFindSquares(target - (i*i), map)
            );
            map.put(target, res);
        }
        return res;
    }

    public int tabulateToFindSquares(int target) {
        /*Initialize a dp array representing subproblems
        i.e how many squares to reach index i*/
        int dp[] = new int[target+1];

        //Fill arrays with target
        Arrays.fill(dp, target);

        //The squares required to reach 0 is always 0
        dp[0] = 0;

        //Fill the dp array for each index
        for (int i=1; i<=target; i++){
            //For each eligible perfect square, the value would 1+(target-square)  
            for (int sq = 1; sq*sq<=i;sq++) {
                dp[i] = Math.min(
                    dp[i], 
                    1+dp[i-(sq*sq)]
                );
            }
        }
        return dp[target];

    }
}
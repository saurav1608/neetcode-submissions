class Solution {
    public int maxProfit(int[] prices) {
        //initialize memoization table, rows become prices and cols become boolean values
        int[][] memo = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        } 

        return calculateMaxProfit(prices, 0, 1, memo); 
    }

    public int calculateMaxProfit(int[] prices, int day, int canBuy, int[][] memo) {
        //base case, days are done and no profit can be generated
        if (day >= prices.length) return 0;

        //if path already explored, directly return the value
        if (memo[day][canBuy] != Integer.MIN_VALUE) return memo[day][canBuy];

        //if there is a potential to buy, check with buying or cooldown
        if (canBuy == 1) {
            memo[day][canBuy] =  Math.max(
                calculateMaxProfit(prices, day+1, 0, memo) - prices[day], //buying path
                calculateMaxProfit(prices, day+1, 1, memo)
            );
        }
        //if stock already bought, check the selling path or cooldown 
        else {
            memo[day][canBuy] =  Math.max(
                calculateMaxProfit(prices, day+2, 1, memo)+ prices[day], 
                calculateMaxProfit(prices, day+1, 0, memo)
            );
        }
        return memo[day][canBuy];
    }
}

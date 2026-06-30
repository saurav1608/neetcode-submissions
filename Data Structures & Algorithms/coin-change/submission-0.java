class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount+1];
        
        //populate the amounts array with huge numbers (avoid overflows bases on variable ranges)
        for (int i = 1; i<amounts.length;i++) {
            amounts[i] = amount+1;
        }
        amounts[0] = 0;

        for (int a = 1; a<amounts.length; a++) {
            for (int c = 0; c < coins.length; c++) {
                if (a-coins[c] >= 0) {
                    amounts[a] = Math.min(amounts[a], 1 + amounts[a-coins[c]]);
                }
            }
        }

        return (amounts[amount] >= amount+1) ? -1 : amounts[amount];   
    }
}

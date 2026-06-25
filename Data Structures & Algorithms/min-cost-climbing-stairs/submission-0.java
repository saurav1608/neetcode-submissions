class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int valueTwoStepsBack = cost[0];
        int valueAtPreviousStep = cost[1];
        for (int i = 2; i<cost.length;i++) {
            int temp = valueAtPreviousStep;
            valueAtPreviousStep = Math.min(valueTwoStepsBack + cost[i],valueAtPreviousStep + cost[i]);
            valueTwoStepsBack = temp;
        }
        return Math.min(valueAtPreviousStep, valueTwoStepsBack);
    }
}

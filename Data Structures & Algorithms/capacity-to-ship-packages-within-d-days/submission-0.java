class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //calculate maxWeight and sum of all weights
        int max = 0;
        int sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum+=weight;
        }

        //run a binary search on the range max weight to sum of all weights
        int left = max;
        int right = sum;
        int result = right;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (weightCanShip(weights, mid, days)) {
                result = Math.min(result, mid);
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    //Check if all containers can be dispatched with the current ship weight
    public boolean weightCanShip(int[] weights, int shipWeight, int days) {
        int daysToShip = 1, currentShipWeight = shipWeight;
        for (int weight : weights) {
            if (currentShipWeight - weight < 0) {
                daysToShip++;
                if (daysToShip > days) return false;
                currentShipWeight = shipWeight;
            }
            currentShipWeight -= weight;
        }
        return true;

    }
}
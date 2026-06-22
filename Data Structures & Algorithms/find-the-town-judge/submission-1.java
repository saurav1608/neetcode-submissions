class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustMatrix = new int[n+1];
        for (int i=0; i<trust.length;i++) {
            trustMatrix[trust[i][0]]--;
            trustMatrix[trust[i][1]]++;
        }

        for (int i=0; i<trustMatrix.length; i++) {
            if (trustMatrix[i] == n-1) return i;
        }
        return -1;
    }
}
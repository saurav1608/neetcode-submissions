class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack();
        int[] ans = new int[temperatures.length];
        stack.push(new int[]{temperatures[0], 0});
        for (int i=1; i<temperatures.length; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] pair = stack.pop();
                ans[pair[1]] = i-pair[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }

        while(!stack.isEmpty()) {
            int[] pair = stack.pop();
            ans[pair[1]] = 0;
        }
        return ans;
    }
}

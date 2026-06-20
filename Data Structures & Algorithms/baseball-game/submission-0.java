class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack();
        populateStack(stack, operations);
        return calculateSumOfElementsInStack(stack);        
    }

    public void populateStack(Stack<Integer> stack, String[] operations) {
        for (String op : operations) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")){
                stack.push(2*stack.peek());
            } else if (op.equals("+")){
                int firstElement = stack.pop();
                int sum = firstElement + stack.peek();
                stack.push(firstElement);
                stack.push(sum);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
    }

    public int calculateSumOfElementsInStack(Stack<Integer> stack) {
        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
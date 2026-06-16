class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        Stack<Integer> stack = new Stack();
        for (String s : tokens) {
            if (isOperation(s)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(performOperation(a, b, s));
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public boolean isOperation(String s) {
        return s.equals("+") || s.equals("-") ||s.equals("*") || s.equals("/");
    }

    public int performOperation(int a, int b, String operation) {
       
        if (operation.equals("+")) {
            return a+b;
        } 
        else if (operation.equals("-")) {
             return a-b;
        } else if (operation.equals("*")) {
             return a*b;
        } else if (operation.equals("/")) {
            return a/b;
        }else {
            return 0;
        }
    }
}

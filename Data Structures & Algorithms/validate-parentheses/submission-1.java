class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char ch : s.toCharArray()) {
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && areBracketPairsMatching(stack.peek(), ch)) {
                    stack.pop();
                } else {
                    return false;
                }

            }
        }
        return stack.isEmpty();
        
    }

    public boolean isOpeningBracket(char ch) {
        return ch=='(' || ch=='{' || ch=='[';
    }

    public boolean areBracketPairsMatching(char src, char tgt) {
        return ((src=='(' && tgt == ')') || 
        (src == '{' && tgt == '}') ||
        (src == '[' && tgt == ']'));
    }
}

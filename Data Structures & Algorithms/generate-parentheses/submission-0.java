class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder combn = new StringBuilder();
        generateParenthesisBacktrack(0,0,n,res,combn);
        return res;
    }

    public void generateParenthesisBacktrack(int open, int close, int n, List<String> res, StringBuilder combn) {
        //base case, if open and closed paranthesis count match n
        if (open == n && close == n) {
            res.add(combn.toString());
            return;
        }

        //case if open < n, we can potentially add ( to the result
        if (open < n) {
            combn.append('(');
            generateParenthesisBacktrack(open+1, close, n, res, combn); 
            combn.deleteCharAt(combn.length()-1);
        }

        //case if close < n, we can add ) to the result
        if (close < open) {
            combn.append(')');
            generateParenthesisBacktrack(open, close+1, n, res, combn);
            combn.deleteCharAt(combn.length()-1);
        }
    }
}

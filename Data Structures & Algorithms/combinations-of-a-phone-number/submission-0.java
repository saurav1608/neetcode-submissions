class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> letterMap = new HashMap<>();
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }
        StringBuilder combn = new StringBuilder();
        findCombinations(0, combn, res, digits, letterMap);
        return res;
    }

    public void findCombinations(int i, StringBuilder combn, List<String> res, String digits, Map<Character, String> letterMap) {
        //base case, if the combn contains characters equal to the length of digits
        if (combn.length() == digits.length()) {
            res.add(combn.toString());
            return;
        }

        String characterSet = letterMap.get(digits.charAt(i));
        //traverse through each character associated to the current digit
        for (char ch : characterSet.toCharArray()) {
            findCombinations(i+1, combn.append(ch), res, digits, letterMap);
            combn.deleteCharAt(combn.length()-1);
        }
    }
}

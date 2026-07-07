class Solution {
    public List<List<String>> partition(String s) {
        List<String> subsets = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        backtrackToFindPartitions(0, s, subsets, result);
        return result;
    }

    public void backtrackToFindPartitions(int i, String s, List<String> subsets, List<List<String>> result) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(subsets));
        }

        for (int j = i; j<s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                subsets.add(s.substring(i, j+1));
                backtrackToFindPartitions(j+1, s, subsets, result);
                subsets.remove(subsets.size()-1);
            }
        } 
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}

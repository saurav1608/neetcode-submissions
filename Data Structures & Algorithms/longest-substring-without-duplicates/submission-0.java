class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int res = 0;
        HashSet<Character> setOfChars = new HashSet<>();
        for (int r = 0; r<s.length(); r++) {
            while (setOfChars.contains(s.charAt(r))) {
                setOfChars.remove(s.charAt(l));
                l++;
            }
            setOfChars.add(s.charAt(r));
            res = Math.max(res, r-l+1);
        }
        return res;
        
    }
}

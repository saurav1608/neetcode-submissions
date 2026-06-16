class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return hashCheck(s, t);

    }

    public boolean hashCheck(String s, String t) {
        HashMap<Character, Integer> stringCharacterCount = new HashMap();
        for (char c : s.toCharArray()) {
            stringCharacterCount.merge(c, 1, Integer::sum);
        } 
        for (char c : t.toCharArray()) {
            if (!stringCharacterCount.containsKey(c)) return false;
            stringCharacterCount.merge(c, -1, Integer::sum);
        }

        return stringCharacterCount.values().stream().noneMatch(v -> v > 0);
    }
}

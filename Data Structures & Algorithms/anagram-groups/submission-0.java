class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return computeAnagramList(strs);
    }

    public List<List<String>> computeAnagramList(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap();
        for(String str : strs) {
            int[] countArray = new int[26];
            for (Character ch : str.toCharArray()) {
                countArray[ch - 'a']++;
            }
            String key = Arrays.toString(countArray);
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(str);
        }
        return new ArrayList<>(anagramMap.values());    
    }
}

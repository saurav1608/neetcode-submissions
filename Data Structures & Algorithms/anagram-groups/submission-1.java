class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> collectionMap = new HashMap<>();
        
        //Build frequency count map and add to hash map
        for (String str : strs) {
            int[] freqMap = new int[26];
            for (int i=0;i<str.length();i++) {
                freqMap[str.charAt(i) - 'a']+=1;
            }
            String key = Arrays.toString(freqMap);
            collectionMap.putIfAbsent(key, new ArrayList<>());
            collectionMap.get(key).add(str);
        }
        return new ArrayList<>(collectionMap.values());


    }
}

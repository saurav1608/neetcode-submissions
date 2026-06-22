class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap();
        List<Integer>[] freq = new List[nums.length + 1];
        
        //Initialize array
        for (int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        //Count the frequency of each element
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        //Populate the frequecy bucket
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        //Populate the result and return
        int res[] = new int[k];
        int insertionIndex = 0;
        for (int i=freq.length-1;i>0 && insertionIndex < k; i--) {
            for (int n : freq[i]){
                res[insertionIndex++] = n;
                if (insertionIndex == k) {
                    return res;
                }
            }
        }
        return res;

    }
}

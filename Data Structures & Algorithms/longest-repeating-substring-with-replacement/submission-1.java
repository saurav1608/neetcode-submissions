class Solution {
    public int characterReplacement(String s, int k) {
        //Map to store frequency of character
        Map<Character, Integer> count = new HashMap();

        //maintain a sliding window 
        int r = 0, l = 0, maxCount = 0, res = 0;
        while (r < s.length()) {
            //add character to map
            count.put(s.charAt(r),
            count.getOrDefault(s.charAt(r), 0) + 1);

            //update the max count of characters seen in the window
            maxCount = Math.max(
                maxCount,
                count.get(s.charAt(r))
            );

            //check if the replacements has exceeded k
            while ((r-l+1) - maxCount > k) {
                //basically the replacements are checked by subtracting the maxCount of characters in the window by the length of window
                count.put(
                    s.charAt(l),
                    count.getOrDefault(s.charAt(l), 0) - 1
                );
                l++;
            }
            res = Math.max(
                res, 
                r - l + 1
            );
            r++;
        }
        return res;
    }
}

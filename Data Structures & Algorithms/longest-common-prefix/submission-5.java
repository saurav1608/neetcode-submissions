class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Vertical Scanning
        // for (int i=0; i<strs[0].length(); i++) {
        //     for (String str : strs) {
        //         if (i == str.length() || str.charAt(i)!= strs[0].charAt(i)) {
        //             return str.substring(0, i);
        //         }
        //     }
        // }
        // return strs[0];
        return withSorting(strs);
    }

    public String withSorting(String[] strs) {
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs);
        int minLen = Math.min(strs[0].length(), strs[strs.length - 1].length());
        for (int i = 0; i < minLen; i++) {
            if (strs[0].charAt(i) != strs[strs.length-1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
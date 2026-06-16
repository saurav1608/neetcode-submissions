class Solution {
    public String longestCommonPrefix(String[] strs) {
        return verticalScan(strs);

    }

    public String verticalScan(String[] strs) {
        for (int i=0; i<strs[0].length();i++) {
            for (String s : strs) {
                if (i == s.length() ||
                s.charAt(i) != strs[0].charAt(i)){
                    return s.substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String horizontalScan(String[] strs) {
        String res = strs[0];
        for (int i=1;i<strs.length;i++) {
            if (res == "") {
                break;
            }
            int j = 0;
            while (j < Math.min(res.length(), strs[i].length())) {
                if (strs[i].charAt(j) != res.charAt(j)){
                    break;
                } else {
                j++;
                }
            }
            res = res.substring(0,j);
        }

        return res;

    }
}
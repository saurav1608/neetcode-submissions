class Solution {
    public String longestCommonPrefix(String[] strs) {
        return horizontalScan(strs);

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
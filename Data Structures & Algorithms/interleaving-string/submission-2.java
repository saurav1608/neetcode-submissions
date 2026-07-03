class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return isInterleaving(
            0, 0, s1, s2, s3, dp
        );
    }

    public boolean isInterleaving(int s1Index, int s2Index, String s1, String s2, String s3, Boolean[][] dp) {
        //base case, both indices are out of bounds
        if (s1Index + s2Index >= s3.length()) {
            return true;
        }

        if (dp[s1Index][s2Index] != null) {
            return dp[s1Index][s2Index];
        }

        //get the characters from all three strings
        char s1Char = (s1Index >= s1.length()) ? '\0' : s1.charAt(s1Index);
        char s2Char = (s2Index >= s2.length()) ? '\0' : s2.charAt(s2Index);
        char s3Char = s3.charAt(s1Index + s2Index);

        //cases where only when character matches
        if (s1Char == s3Char && s2Char != s3Char) {
            dp[s1Index][s2Index] =  isInterleaving(s1Index+1, s2Index, s1, s2, s3, dp);
        } else if (s1Char != s3Char && s2Char == s3Char) {
            dp[s1Index][s2Index] = isInterleaving(s1Index, s2Index+1, s1, s2, s3, dp);
        }
        //case where both characters match 
        else if (s1Char == s3Char && s2Char == s3Char){
            dp[s1Index][s2Index] =  isInterleaving(s1Index+1, s2Index, s1, s2, s3, dp) ||
            isInterleaving(s1Index, s2Index + 1, s1, s2, s3, dp);
        } //case where no character matches
        else {
            dp[s1Index][s2Index] = false;
        }
        return dp[s1Index][s2Index];
    }
}

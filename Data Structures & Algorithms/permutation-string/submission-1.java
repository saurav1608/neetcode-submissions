class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //no checks needed if s1 is bigger
        if (s1.length() > s2.length()) return false;
        
        //initialize two arrays to hold count of characters
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        //fill the character count of s1 and len(s1) characters of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']+=1;
            s2Count[s2.charAt(i) - 'a']+=1;
        }
        
        int left = 0;
        //keep checking equality on a window of len(s1) running over s2
        for (int right = s1.length(); right < s2.length(); right++) {
            if (Arrays.equals(s1Count, s2Count)) return true;
            s2Count[s2.charAt(right) - 'a']+=1;
            s2Count[s2.charAt(left) - 'a']-=1;
            left++;
        }
        return Arrays.equals(s1Count, s2Count);
    }
}

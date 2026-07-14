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

        //instead of checking equality at each step, we can just maintain a variable matches
        //at any point, if the matches are 26, the permutation exists
        //start by calculating the matches in the first window
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) matches++;
        }
        
        int left = 0;
        //keep checking equality on a window of len(s1) running over s2
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) return true;

            //handle matches for the current right index change
            int index = s2.charAt(right) - 'a';
            s2Count[index]+=1;

            //increment if the character at right's count matches after increment
            if (s2Count[index] == s1Count[index]) {
                matches +=1;
            }
            //decrement if there was a match previously but the match was destroyed by current increment 
            else if (s2Count[index] == s1Count[index] + 1) {
                matches -=1;
            }

            //handle matches for the left index change
            index = s2.charAt(left) - 'a';
            s2Count[index]-=1;
            //increment if the character at left's count matches after increment
            if (s2Count[index] == s1Count[index]) {
                matches +=1;
            }
            //decrement if there was a match previously but the match was destroyed by current decrement 
            else if (s2Count[index] + 1 == s1Count[index]) {
                matches -= 1;
            }
            left++;
        }
        return matches == 26;
    }
}

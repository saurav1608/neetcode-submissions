class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        //create pointers to mark start and end
        int start = 0, end = s.length()-1;
        while(start < end) {
            //skip if start or end is not an alphanumeric character
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            } else {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
        
    }
}

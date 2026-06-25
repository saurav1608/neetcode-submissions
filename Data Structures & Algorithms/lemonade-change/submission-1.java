class Solution {
    public boolean lemonadeChange(int[] bills) {
        int notesOfFive = 0;
        int notesOfTen = 0;
        for (int bill : bills) {
            if (bill == 5) {
                notesOfFive++;
            } else if (bill == 10) {
                if (notesOfFive <= 0) return false;
                else {
                    notesOfFive--;
                    notesOfTen++;
                }
            } else {
                if (notesOfFive > 0 && notesOfTen > 0) {
                    notesOfFive--;
                    notesOfTen--;
                } else if (notesOfFive >=3) {
                    notesOfFive-=3;
                } else {
                    return false;
                }
            }
        }
                    return true;
   
    }
}
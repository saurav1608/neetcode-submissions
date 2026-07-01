class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceUsingArrays(text1, text2);    
    }

        public int longestCommonSubsequenceUsingArrays(String text1, String text2) {
        int rowCount = text1.length() + 1;
        int colCount = text2.length() + 1;
        int[] dpGrid = new int[colCount];

        //fill the array
         for (int row=1; row < rowCount; row++) {
            int prevDiagonal = 0;
            for (int col=1; col < colCount; col++) {
                int temp = dpGrid[col];
                //If characters are equal, the longest subsequence is the value with the character removed + 1
                if (text1.charAt(row-1) == text2.charAt(col-1)) {
                    dpGrid[col] = 1+ prevDiagonal;
                } else {
                    //If values are unequal, the longest subsequence is the max of value with one char removed from txt1 and one cahr removed from txt2
                    dpGrid[col] = Math.max(dpGrid[col-1] , dpGrid[col]);
                }
                prevDiagonal = temp;
            }
        }
        return dpGrid[colCount-1];        
    }

    public int longestCommonSubsequenceUsingMatrix(String text1, String text2) {
        int rowCount = text1.length() + 1;
        int colCount = text2.length() + 1;

        int[][] dpGrid = new int[rowCount][colCount];
        //populate the empty string scenarios
        for (int col=0; col < colCount; col++){
            dpGrid[0][col] = 0;
        }
        //populate the empty string scenarios
        for (int row=0; row < rowCount; row++) {
            dpGrid[row][0] = 0;
        }

        //fill the dp grid
         for (int row=1; row < rowCount; row++) {
            for (int col=1; col < colCount; col++) {
                //If characters are equal, the longest subsequence is the value with the character removed + 1
                if (text1.charAt(row-1) == text2.charAt(col-1)) {
                    dpGrid[row][col] = 1+ dpGrid[row-1][col-1];
                } else {
                    //If values are unequal, the longest subsequence is the max of value with one char removed from txt1 and one cahr removed from txt2
                    dpGrid[row][col] = Math.max(dpGrid[row-1][col] , dpGrid[row][col-1]);
                }
            }
        }

        return dpGrid[rowCount-1][colCount-1];
    }
}

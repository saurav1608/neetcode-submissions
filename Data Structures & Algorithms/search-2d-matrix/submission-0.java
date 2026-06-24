class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //find row in which target exists
        int start = 0;
        int end = rows-1;
        int targetRow = end;
        while (start <= end) {
            int mid = (start+end)/2;
            if (target < matrix[mid][0]) end = mid-1;
            else if(target > matrix[mid][cols-1]) start = mid+1;
            else {
                targetRow = mid;
                break;    
            }
        }

        //Return false if check have failed for all row
        if (! (start <= end)) return false;

        //Initiate a search in the target row 
        start = 0;
        end = cols-1;
        while (start <= end) {
            int mid = (start+end) / 2;
            if (matrix[targetRow][mid] == target) return true;
            else if (matrix[targetRow][mid] > target) end = mid-1;
            else start = mid+1;
        }
        return false;
    }

    
}

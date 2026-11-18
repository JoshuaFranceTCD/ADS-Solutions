/* binary search to find the row: target row starts with element <= target and ends with element >= target */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bottom = matrix.length - 1;

        int rowIndex = 0;

        while( top <= bottom){
            int midRow = top + (bottom - top)/2;
            if(matrix[midRow][0] <= target && matrix[midRow][COLS-1] >= target){
                rowIndex = midRow;
                break;
            }
            else if(matrix[midRow][0] > target){
                bottom = midRow - 1;
            }
            else{
                top = midRow + 1;
            }
        }
        if(top > bottom) return false;

        int[] targetRow = matrix[rowIndex];

        int l = 0, r = COLS - 1;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(targetRow[mid] == target) return true;
            if(targetRow[mid] < target){
                l = mid + 1;
            }
            else{
                r = mid  - 1;
            }
        }
        return false;


        


        
        
    }
}

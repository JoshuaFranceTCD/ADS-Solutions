/* treating entire matrix as one row */

/*  converting double index to single:
        matix[row][col] = Rowsize * row + col
    converting single index to doublw
        row = index / RowSize, col = remained of index/rowSi

        e.g.
        0 1 2           
        3 4 5           
        6 7 8 
        to get 5th element, row = 5/3 = 1, col = 5 % 3
        think, how many rows do I need to cross get to the 5th element?
        how many elements will be left over?


*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int ROWSIZE = matrix[0].length; 

        int l = 0, r = ROWS * ROWSIZE - 1;

        while( l <= r){
            int m = l + (r-l)/2;
            int row = m / ROWSIZE; 
            int col = m % ROWSIZE;
            if (target > matrix[row][col]) {
                l = m + 1;
            } else if (target < matrix[row][col]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
        
    }
}

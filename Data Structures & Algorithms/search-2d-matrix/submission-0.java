class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int[] targetRow = matrix[0];
        for(int[] row : matrix ){
            if(row[0]  > target) break;
            targetRow = row;
        }

        int l = 0, r = targetRow.length - 1;

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

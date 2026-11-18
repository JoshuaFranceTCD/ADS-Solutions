class Solution {
    public int search(int[] nums, int target) {

        int l = 0; int r = nums.length - 1;

        int m = l + (r-l)/2;

        while(l <= r){
            //System.out.println("l: "+ l + "r: " + r + " m: " + m);
            if(nums[m] == target) return m;
            else if(nums[m] > target){
                r = m - 1;
            }
            else{
                l = m + 1;
            }
            m = l + (r-l)/2;
        }
        return - 1;
        
    }
}

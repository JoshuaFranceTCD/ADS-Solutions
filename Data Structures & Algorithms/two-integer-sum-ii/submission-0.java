class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int[] index = new int[]{1,numbers.length};

        while(index[0] < index[1]){
            int sum = numbers[index[0]-1] + numbers[index[1]-1];
            if(sum == target) break;
            else if (sum > target) index[1]--;
            else index[0]++;
        }
        return index;
        
    }
}

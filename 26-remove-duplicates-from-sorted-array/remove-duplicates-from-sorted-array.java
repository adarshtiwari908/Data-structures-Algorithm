class Solution {
    public int removeDuplicates(int[] nums) {
        int uniquePos = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[i-1]){
                nums[uniquePos] = nums[i];
                uniquePos++;
            }
        }
        return uniquePos;
    }
}
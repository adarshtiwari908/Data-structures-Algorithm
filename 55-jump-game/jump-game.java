class Solution {
    public boolean canJump(int[] nums) {
/* m is maxReachable point and example we've simply [2,3,1,1,4].
so, at first index we have 2 and that is our max... and so on as we loop through array*/
        int m = 0;
        for(int i = 0; i < nums.length; i++){
            if( i > m )return false; //case 2 given in question already i is the where we want to reach
            else m = Math.max(m, i + nums[i]);
        }
        return true;
    }
}
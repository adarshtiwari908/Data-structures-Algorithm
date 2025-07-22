class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        // Case 1: Exclude the last house (rob from index 0 to n-2)
        int case1 = robLinear(nums, 0, nums.length - 2);
        // Case 2: Exclude the first house (rob from index 1 to n-1)
        int case2 = robLinear(nums, 1, nums.length - 1);
        
        return Math.max(case1, case2);
    }
    
    private int robLinear(int[] nums, int start, int end) {
        if (start > end) return 0;
        int prev2 = 0; // Money robbed up to house i-2
        int prev1 = 0; // Money robbed up to house i-1
        
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}
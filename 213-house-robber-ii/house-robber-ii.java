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
        
        int n = end - start + 1; // Number of houses in the range
        int[] dp = new int[n];
        
        // Base cases
        dp[0] = nums[start]; // First house in the range
        if (n == 1) return dp[0];
        dp[1] = Math.max(nums[start], nums[start + 1]); // Max of first two houses
        
        // Fill DP array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        
        return dp[n - 1];
    }
}
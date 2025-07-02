class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        // 3D DP array: day, transactions_done, canBuy
        int[][][] dp = new int[n][3][2];
        
        // Fill with -1 to indicate "not calculated"
        for (int[][] row : dp)
            for (int[] col : row)
                Arrays.fill(col, -1);
        
        // Start from day 0, 0 transactions done, and we can buy
        return helper(0, 0, 1, prices, dp);
    }

    private int helper(int i, int transactions, int canBuy, int[] prices, int[][][] dp) {
        // Base Case: no more days or completed 2 transactions
        if (i == prices.length || transactions == 2)
            return 0;

        // If result already calculated, return from memory
        if (dp[i][transactions][canBuy] != -1)
            return dp[i][transactions][canBuy];

        int profit = 0;

        if (canBuy == 1) {
            // We can either buy today or skip
            int buy = -prices[i] + helper(i + 1, transactions, 0, prices, dp);
            int skip = helper(i + 1, transactions, 1, prices, dp);
            profit = Math.max(buy, skip);
        } else {
            // We can either sell today or skip
            int sell = prices[i] + helper(i + 1, transactions + 1, 1, prices, dp);
            int skip = helper(i + 1, transactions, 0, prices, dp);
            profit = Math.max(sell, skip);
        }

        // Store the result in dp array and return it
        return dp[i][transactions][canBuy] = profit;
    }
}

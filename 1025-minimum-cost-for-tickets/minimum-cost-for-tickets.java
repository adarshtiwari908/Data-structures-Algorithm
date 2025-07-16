class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        boolean[] travel = new boolean[366]; // day 1 to 365
        for (int day : days) {
            travel[day] = true;
        }

        int[] dp = new int[366];

        for (int i = 1; i <= 365; i++) {
            if (!travel[i]) {
                dp[i] = dp[i - 1];  // no travel, no extra cost
            } else {
                int cost1 = dp[i - 1] + cost[0];               // 1-day pass
                int cost7 = dp[Math.max(0, i - 7)] + cost[1];  // 7-day pass
                int cost30 = dp[Math.max(0, i - 30)] + cost[2];// 30-day pass
                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }

        return dp[days[days.length - 1]];  // cost up to the last travel day
    }
}

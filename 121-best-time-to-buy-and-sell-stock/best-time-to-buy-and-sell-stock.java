public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // No profit possible with 0 or 1 price
        }
        
        int minPrice = prices[0]; // Track minimum price seen so far
        int maxProfit = 0; // Track maximum profit possible
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // Update minimum price
            } else {
                int currentProfit = prices[i] - minPrice; // Profit if sell now
                maxProfit = Math.max(maxProfit, currentProfit); // Update max profit
            }
        }
        
        return maxProfit;
    }
}
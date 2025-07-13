class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // Edge case: empty string
        if (n == 0 || s.charAt(0) == '0') return 0;
        
        // dp[i] = number of ways to decode s[0:i]
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty string has 1 way (base case)
        dp[1] = 1; // First character, valid if not '0'
        
        // Iterate through the string starting from index 1
        for (int i = 2; i <= n; i++) {
            // Check if single digit (s[i-1]) is valid (1-9)
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            // Check if two digits (s[i-2:i]) are valid (10-26)
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}
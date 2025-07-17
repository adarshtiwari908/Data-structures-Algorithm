public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string and empty pattern match
        dp[0][0] = true;
        
        // Handle patterns starting with * (e.g., a*, a*b*)
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == '*') {
                    // Zero occurrences (skip the char and *)
                    dp[i][j] |= dp[i][j - 2];
                    // One or more occurrences (if chars match)
                    if (j >= 2 && (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else if (pc == '.' || sc == pc) {
                    // Match current characters, check previous
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
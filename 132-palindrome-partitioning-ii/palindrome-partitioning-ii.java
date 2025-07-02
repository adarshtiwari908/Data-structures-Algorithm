class Solution {
    int[][] dp;
    boolean[][] isPalindrome;

    public int minCut(String s) {
        int n = s.length();
        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Precompute palindromes
        isPalindrome = new boolean[n][n];
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) &&
                   (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        return solve(s, 0, n - 1);
    }

    private int solve(String s, int i, int j) {
        if (i >= j || isPalindrome[i][j]) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            if (isPalindrome[i][k]) {
                int right = solve(s, k + 1, j);
                min = Math.min(min, 1 + right);
            }
        }

        return dp[i][j] = min;
    }
}

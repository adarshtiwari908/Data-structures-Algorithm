class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int nSquared = n * n;
        int[] count = new int[nSquared + 1];
        int[] ans = new int[2]; // ans[0] = duplicate, ans[1] = missing

        // Count occurrences
        for (int[] row : grid) {
            for (int x : row) {
                count[x]++;
                if (count[x] == 2) {
                    ans[0] = x;
                }
            }
        }

        // Find missing number
        for (int i = 1; i <= nSquared; i++) {
            if (count[i] == 0) {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}

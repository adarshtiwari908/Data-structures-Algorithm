class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        
        // Iterate over all possible starting indices
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // Iterate over all possible ending indices
            for (int j = i; j < n; j++) {
                // Add current element to sum
                sum += nums[j];
                // Check if sum equals k
                if (sum == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
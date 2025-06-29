class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countSubarrays(nums, right) - countSubarrays(nums, left - 1);
    }
    
    // Count subarrays where maximum element <= maxVal
    private int countSubarrays(int[] nums, int maxVal) {
        int count = 0;
        int length = 0;
        
        for (int num : nums) {
            if (num <= maxVal) {
                length++;
                count += length;
            } else {
                length = 0;
            }
        }
        
        return count;
    }
}
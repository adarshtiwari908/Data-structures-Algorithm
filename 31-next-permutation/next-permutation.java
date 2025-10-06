class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        // 1. Find the pivot (first decreasing element from the right)
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // If a pivot is found (i >= 0)
        if (i >= 0) {
            // 2. Find the swap element (smallest element greater than nums[i] in the suffix)
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Swap nums[i] and nums[j]
            swap(nums, i, j);
        }
        
        // 3. Reverse the suffix from i + 1 to the end
        reverse(nums, i + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
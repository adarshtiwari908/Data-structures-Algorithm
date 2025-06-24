class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in right half
                left = mid + 1;
            } else {
                // Minimum is in left half or at mid
                right = mid;
            }
        }

        return nums[left];  // or nums[right], both point to min
    }
}

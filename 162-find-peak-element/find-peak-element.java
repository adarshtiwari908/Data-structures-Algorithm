class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is smaller than its next element
            if (nums[mid] < nums[mid + 1]) {
                // Peak must be on the right
                left = mid + 1;
            } else {
                // Peak is on the left or at mid
                right = mid;
            }
        }

        // left == right → pointing at a peak element
        return left;
    }
}

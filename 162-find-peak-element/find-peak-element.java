class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1; // peak lies on right
            } else {
                right = mid;    // peak is at mid or to the left
            }
        }

        return left; // or right
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1; // peak is on the right
            } else {
                right = mid;    // peak is at mid or to the left
            }
        }

        return left; // or right, since both will point to peak
    }
}

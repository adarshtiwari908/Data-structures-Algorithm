class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // Step 1: Sort the array
        int n = nums.length;

        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with first 3 numbers

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If currentSum is closer to target than previous closest, update it
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers
                if (currentSum < target) {
                    left++; // Try to increase the sum
                } else if (currentSum > target) {
                    right--; // Try to decrease the sum
                } else {
                    return currentSum; // Perfect match!
                }
            }
        }

        return closestSum;
    }
}

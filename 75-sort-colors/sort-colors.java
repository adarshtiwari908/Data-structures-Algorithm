class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0;       // for 0
        int j = 0;       // for 1
        int k = n - 1;   // for 2

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else { // nums[j] == 0
                swap(nums, j, i);
                j++;
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

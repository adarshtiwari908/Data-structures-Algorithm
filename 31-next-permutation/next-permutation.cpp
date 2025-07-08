class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int i = n - 2;

        // Step 1: Find first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If such element found, find just greater element to the right
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap nums[i] and nums[j]
            swap(nums[i], nums[j]);
        }

        // Step 3: Reverse the part from i+1 to end
        reverse(nums.begin() + i + 1, nums.end());
    }
};

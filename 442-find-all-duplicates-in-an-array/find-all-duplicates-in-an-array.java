class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                ans.add(Math.abs(num));
            }
            nums[idx] = -nums[idx];
        }
        return ans;
    }
}
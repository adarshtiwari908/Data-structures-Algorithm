class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int count = 0;

            boolean alreadyAdded = false;
            for (int x : result) {
                if (x == nums[i]) {
                    alreadyAdded = true;
                    break;
                }
            }
            if (alreadyAdded) continue;

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 3) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}

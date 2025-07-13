class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            // Calculate the complement needed
            int complement = target - currentNum;

            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                // If found, return the indices
                return new int[]{numMap.get(complement), i};
            }

            // If not found, put the current number and its index into the map
            numMap.put(currentNum, i);
        }

        // This part should theoretically not be reached given the problem constraints
        // that there is exactly one solution.
        return new int[]{};
    }
}
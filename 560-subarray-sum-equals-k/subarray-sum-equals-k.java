import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        // Map to store (prefixSum, frequency)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: sum = 0 occurs once

        for (int num : nums) {
            sum += num; // running sum

            // check if (sum - k) exists in map
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // update the frequency of current sum in map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

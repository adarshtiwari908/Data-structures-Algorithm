/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1); // base case
        dfs(root, 0, targetSum, prefixSumMap);
        return count;
    }

    private void dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> map) {
        if (node == null) return;

        currSum += node.val;

        // Check if there is a prefix sum such that currSum - prefix = targetSum
        count += map.getOrDefault(currSum - targetSum, 0);

        // Update map
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        dfs(node.left, currSum, targetSum, map);
        dfs(node.right, currSum, targetSum, map);

        // Backtrack
        map.put(currSum, map.get(currSum) - 1);
    }
}
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result; // empty tree

        helper(root, "", result); // call helper function
        return result;
    }

    private void helper(TreeNode node, String path, List<String> result) {
        if (node == null) return; // base case

        // Add current node value to path
        path += node.val;

        // If it's a leaf node (no children), add the path to the result
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // If not a leaf, add '->' and go left and right
        path += "->";
        helper(node.left, path, result);
        helper(node.right, path, result);
    }
}

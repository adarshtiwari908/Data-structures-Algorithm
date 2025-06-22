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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        // Queue to store node and its index
        Queue<Pair<TreeNode, Long>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0L));
        long maxWidth = 1;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long leftmostIndex = 0;
            long rightmostIndex = 0;
            
            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Long> pair = queue.poll();
                TreeNode node = pair.getKey();
                long index = pair.getValue();
                
                // Set leftmost index for the first node in the level
                if (i == 0) {
                    leftmostIndex = index;
                }
                // Update rightmost index for each node
                rightmostIndex = index;
                
                // Add left child with normalized index
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * (index - leftmostIndex)));
                }
                // Add right child with normalized index
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * (index - leftmostIndex) + 1));
                }
            }
            
            // Calculate width of current level
            long currentWidth = rightmostIndex - leftmostIndex + 1;
            maxWidth = Math.max(maxWidth, currentWidth);
        }
        
        return (int) maxWidth;
    }
}
import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start with the root

        while (!queue.isEmpty()) {
            int size = queue.size();  // Number of nodes at this level

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // If it's the last node in this level, add to result
                if (i == size - 1) {
                    result.add(current.val);
                }

                // Add children to queue
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }

        return result;
    }
}

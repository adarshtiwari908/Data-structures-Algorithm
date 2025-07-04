class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // start from root

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // nodes in current level
            double sum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                sum += current.val;

                // Add children to queue for next level
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.add(sum / levelSize);  // average of this level
        }

        return result;
    }
}

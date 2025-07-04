import java.util.*;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left  != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            result.addFirst(level);   // key line: prepend instead of append
        }
        return result;
    }
}
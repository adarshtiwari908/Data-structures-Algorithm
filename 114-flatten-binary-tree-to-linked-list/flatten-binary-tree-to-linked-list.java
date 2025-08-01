class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();

            if (currNode.right != null) {
                stack.push(currNode.right);
            }

            if (currNode.left != null) {
                stack.push(currNode.left);
            }

            if (!stack.isEmpty()) {
                currNode.right = stack.peek();
            }

            currNode.left = null;
        }
    }
}

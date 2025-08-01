class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);   // Step 1
        flatten(root.left);    // Step 2

        root.right = prev;     // Step 3
        root.left = null;
        prev = root;           // Step 4
    }
}
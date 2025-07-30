class Solution {
    int preorderIndex = 0; // Tracks next root in preorder
    Map<Integer, Integer> inorderMap = new HashMap<>(); // Maps inorder values to indices
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store inorder indices: {9->0, 3->1, 20->2}
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int inorderStart, int inorderEnd) {
        // If no elements in this subtree, return null
        if (inorderStart > inorderEnd) {
            return null;
        }
        
        // Get root value (e.g., 3, then 9, then 20)
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        
        // Find root’s index in inorder (e.g., 3 at index 1)
        int inorderRootIndex = inorderMap.get(rootVal);
        
        // Build left subtree (e.g., for [9], range [0, 0])
        root.left = buildTreeHelper(preorder, inorderStart, inorderRootIndex - 1);
        // Build right subtree (e.g., for [20], range [2, 2])
        root.right = buildTreeHelper(preorder, inorderRootIndex + 1, inorderEnd);
        
        return root;
    }
}
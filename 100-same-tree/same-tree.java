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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null ) return true;
        if ( p == null || q == null ) return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// step 1: if both binary trees are null then true;
// step 2: if one of the trees == null then false;
// step 3: first we will check current nodde values are equal or not
// step 4: Recursively check if the left subtrees are the same and same for right subtrees.
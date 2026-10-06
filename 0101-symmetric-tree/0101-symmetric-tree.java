class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // Compare the left subtree and the right subtree as mirrors of each other
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Base case: both nodes are null, matching perfectly
        if (t1 == null && t2 == null) return true;
        
        // One node is null while the other isn't, so they are not symmetric
        if (t1 == null || t2 == null) return false;
        
        // Values don't match, so they are not symmetric
        if (t1.val != t2.val) return false;
        
        // Check if the outer child nodes and the inner child nodes mirror each other
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}

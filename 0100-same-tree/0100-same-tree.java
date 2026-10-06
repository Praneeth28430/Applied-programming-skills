class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: both nodes are null, so they are identical
        if (p == null && q == null) {
            return true;
        }
        
        // One of the nodes is null while the other isn't, so they don't match
        if (p == null || q == null) {
            return false;
        }
        
        // Values don't match, so they aren't the same tree
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check if the left subtrees and right subtrees are identical
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

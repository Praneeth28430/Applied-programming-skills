import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) return;
        
        // If this is the first time we visit this depth level, 
        // it must be the rightmost node seen so far.
        if (depth == result.size()) {
            result.add(node.val);
        }
        
        // Traverse the right subtree first to prioritize the rightmost views
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}

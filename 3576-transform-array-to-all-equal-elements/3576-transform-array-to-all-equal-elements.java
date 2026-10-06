class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        return checkTarget(nums, 1, k) || checkTarget(nums, -1, k);
    }
    
    private boolean checkTarget(int[] nums, int target, int k) {
        int ops = 0;
        // Clone or track the forward lookahead state smoothly
        int currentDiff = 0; 
        
        // We simulate the flips using a copy or inline tracking
        int[] arr = nums.clone();
        
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != target) {
                // Flip current and next element
                arr[i] = target;
                arr[i + 1] *= -1;
                ops++;
            }
        }
        
        // Check if the last element matches the target and ops are within limit
        return arr[arr.length - 1] == target && ops <= k;
    }
}

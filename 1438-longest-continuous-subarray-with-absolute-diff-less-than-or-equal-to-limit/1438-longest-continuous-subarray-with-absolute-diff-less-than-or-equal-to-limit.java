import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // Deques to maintain the maximum and minimum elements' values/indices in the current window
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Maintain decreasing order in maxDeque
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(nums[right]);
            
            // Maintain increasing order in minDeque
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(nums[right]);
            
            // If the absolute difference violates the limit, shrink the window from the left
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                left++; // Move the left boundary of the window forward
            }
            
            // Update the maximum length of a valid subarray found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

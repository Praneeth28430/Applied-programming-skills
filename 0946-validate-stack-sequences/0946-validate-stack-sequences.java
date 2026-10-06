import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0; // Pointer to track elements in the popped array
        
        for (int val : pushed) {
            stack.push(val); // Greedily push the current element
            
            // Check if the top of the stack matches the current expected popped element
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        
        // If the simulation is successful, all elements should have been popped
        return stack.isEmpty();
    }
}

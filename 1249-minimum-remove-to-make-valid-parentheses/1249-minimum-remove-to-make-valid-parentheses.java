import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        // Stack to store the indices of opening brackets '('
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            
            if (c == '(') {
                stack.push(i); // Keep track of the opening bracket's position
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Found a valid pair, remove matching '(' index
                } else {
                    // Mismatched closing bracket: mark it for removal
                    sb.setCharAt(i, '*'); 
                }
            }
        }
        
        // Any indices left in the stack are mismatched opening brackets
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        
        // Build the final string by omitting the marked invalid characters
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '*') {
                result.append(sb.charAt(i));
            }
        }
        
        return result.toString();
    }
}

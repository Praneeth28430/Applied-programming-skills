class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Use an array to act as our stack, using `top` as the pointer index
        int[] stack = new int[asteroids.length];
        int top = -1; 
        
        for (int ast : asteroids) {
            boolean exploded = false;
            
            // Collision happens ONLY when stack top moves right (+) and current asteroid moves left (-)
            while (top >= 0 && stack[top] > 0 && ast < 0) {
                if (stack[top] < Math.abs(ast)) {
                    top--;    // The right-moving asteroid is smaller, it explodes (pop)
                    continue; // Keep checking against the new top element
                } else if (stack[top] == Math.abs(ast)) {
                    top--;    // Both asteroids are equal size, both explode
                    exploded = true;
                    break;
                } else {
                    // The right-moving asteroid is larger, current asteroid explodes
                    exploded = true;
                    break;
                }
            }
            
            // If the current asteroid survived all collisions, add it to our array stack
            if (!exploded) {
                stack[++top] = ast;
            }
        }
        
        // Construct the final result using only the active elements in the stack array
        int[] result = new int[top + 1];
        System.arraycopy(stack, 0, result, 0, top + 1);
        
        return result;
    }
}

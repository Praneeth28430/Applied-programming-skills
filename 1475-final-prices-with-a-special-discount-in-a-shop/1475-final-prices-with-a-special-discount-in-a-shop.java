import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone(); // Clone original prices to apply discounts directly
        Stack<Integer> stack = new Stack<>(); // Stores indices of items
        
        for (int i = 0; i < n; i++) {
            // While stack is not empty and current price is less than or equal to the price at stack's top index
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = prices[prevIndex] - prices[i]; // Apply the discount
            }
            stack.push(i); // Push the current item's index
        }
        
        return result;
    }
}

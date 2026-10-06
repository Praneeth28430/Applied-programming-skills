import java.util.Stack;

class StockSpanner {
    // Stack stores pairs of int[] where:
    // element[0] = price of the stock
    // element[1] = span of that price
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // Accumulate spans of all previous days with a price less than or equal to current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        // Push the current price and its calculated span onto the stack
        stack.push(new int[]{price, span});
        
        return span;
    }
}

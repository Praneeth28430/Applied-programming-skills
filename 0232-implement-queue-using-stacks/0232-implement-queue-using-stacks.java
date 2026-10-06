import java.util.Stack;

class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    // O(1) time complexity
    public void push(int x) {
        input.push(x);
    }
    
    // Amortised O(1) time complexity
    public int pop() {
        peek(); // Ensure output stack has the current elements
        return output.pop();
    }
    
    // Amortised O(1) time complexity
    public int peek() {
        // Move elements from input to output only when output is empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    // O(1) time complexity
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

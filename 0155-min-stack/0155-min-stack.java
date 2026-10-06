class MinStack {
    private Node head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            // The new node tracks its own value and the minimum between its value and the previous min
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    // Custom helper class to store value, running minimum, and next reference
    private static class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            // Correct assignment order
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

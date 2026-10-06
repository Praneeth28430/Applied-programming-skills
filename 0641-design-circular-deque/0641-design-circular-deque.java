class MyCircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.deque = new int[k];
        this.front = 0;
        this.rear = k - 1; // Position rear right behind front initially
        this.count = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        
        // Circularly move front counter-clockwise: (front - 1 + capacity) % capacity
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        count++;
        
        // Handle structural synchronization if this is the first item added
        if (count == 1) {
            rear = front;
        }
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        
        // Circularly move rear clockwise
        rear = (rear + 1) % capacity;
        deque[rear] = value;
        count++;
        
        // Handle structural synchronization if this is the first item added
        if (count == 1) {
            front = rear;
        }
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        
        // Circularly move front clockwise
        front = (front + 1) % capacity;
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        
        // Circularly move rear counter-clockwise: (rear - 1 + capacity) % capacity
        rear = (rear - 1 + capacity) % capacity;
        count--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return deque[rear];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}

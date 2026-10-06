import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        // Initialize an empty queue to keep track of incoming pings
        this.queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add the current request time to the queue
        queue.add(t);
        
        // Evict pings that occurred outside the valid window [t - 3000, t]
        int minAllowedTime = t - 3000;
        while (!queue.isEmpty() && queue.peek() < minAllowedTime) {
            queue.poll();
        }
        
        // The remaining size of the queue represents the active pings in the window
        return queue.size();
    }
}

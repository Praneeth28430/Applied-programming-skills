public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode tortoise = head;
        ListNode hare = head;
        boolean hasCycle = false;
        
        // Phase 1: Detect if a cycle exists
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            
            if (tortoise == hare) {
                hasCycle = true;
                break;
            }
        }
        
        // If no cycle is found, return null
        if (!hasCycle) return null;
        
        // Phase 2: Find the start of the cycle
        ListNode ptr1 = head;
        ListNode ptr2 = tortoise; // where tortoise and hare met
        
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return ptr1; // This is the node where the cycle begins
    }
}

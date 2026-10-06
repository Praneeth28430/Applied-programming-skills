class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pointerGroupPrev = dummy;
        
        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode kthNode = getKthNode(pointerGroupPrev, k);
            if (kthNode == null) {
                break; // Less than k nodes left, keep them as they are
            }
            
            ListNode pointerGroupNext = kthNode.next;
            
            // Reverse the current k-group
            ListNode prev = pointerGroupNext; // Connect the tail of reversed sublist to the remaining list
            ListNode curr = pointerGroupPrev.next;
            
            while (curr != pointerGroupNext) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            
            // Connect the previous section to the newly reversed group head
            ListNode nextGroupPrev = pointerGroupPrev.next;
            pointerGroupPrev.next = kthNode;
            pointerGroupPrev = nextGroupPrev;
        }
        
        return dummy.next;
    }
    
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}

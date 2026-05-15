class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Handle empty list or single-node list
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Duplicate found: skip the next node
                current.next = current.next.next;
            } else {
                // No duplicate: move to the next node
                current = current.next;
            }
        }
        
        return head;
    }
}
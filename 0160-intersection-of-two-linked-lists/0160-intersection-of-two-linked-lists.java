import java.util.HashSet;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visited = new HashSet<>();
        
        ListNode currentA = headA;
        while (currentA != null) {
            visited.add(currentA);
            currentA = currentA.next;
        }
        
        ListNode currentB = headB;
        while (currentB != null) {
            if (visited.contains(currentB)) {
                return currentB;
            }
            currentB = currentB.next;
        }
        
        return null;
    }
}
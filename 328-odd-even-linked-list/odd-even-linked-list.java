/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Edge cases: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Initialize pointers
        ListNode odd = head;           // Points to current odd node
        ListNode even = head.next;     // Points to current even node
        ListNode evenHead = even;      // Store head of even list
        
        // Traverse and rearrange
        while (even != null && even.next != null) {
            odd.next = even.next;      // Link odd to next odd node
            odd = odd.next;            // Move to next odd node
            even.next = odd.next;      // Link even to next even node
            even = even.next;          // Move to next even node
        }
        
        // Connect odd list to even list
        odd.next = evenHead;
        
        return head;
    }
}
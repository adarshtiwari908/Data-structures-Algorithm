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
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // Link next odd
            odd.next = even.next;
            odd = odd.next;

            // Link next even
            even.next = even.next.next;
            even = even.next;
        }

        // Append even list at the end of odd list
        odd.next = evenHead;

        return head;
    }
}

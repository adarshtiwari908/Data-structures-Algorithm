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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Check if there are at least k nodes left
        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        
        if (count < k) return head; // Not enough nodes to reverse

        // Step 2: Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Recur for remaining list and connect
        head.next = reverseKGroup(curr, k);

        // Return new head after reversal
        return prev;
    }
}

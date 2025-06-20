/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int pairSum(ListNode head) {
        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half starting at slow.next
        ListNode second = reverse(slow.next);
        slow.next = null; // Optional: split list

        // Step 3: Compute maximum twin sum
        int maxSum = 0;
        ListNode first = head, ptr = second;
        while (ptr != null) {
            maxSum = Math.max(maxSum, first.val + ptr.val);
            first = first.next;
            ptr = ptr.next;
        }

        return maxSum;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }
}

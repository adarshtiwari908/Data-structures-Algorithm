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
    public ListNode sortList(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head.next; // Move fast one step ahead to get left half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split the list into two halves
        ListNode secondHalf = slow.next;
        slow.next = null; // Disconnect the first half
        
        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(secondHalf);
        
        // Step 3: Merge the sorted halves
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify merging
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Compare and merge nodes in ascending order
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // Attach remaining nodes, if any
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        
        return dummy.next;
    }
}
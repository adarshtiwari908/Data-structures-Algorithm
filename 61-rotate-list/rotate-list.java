class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases: empty list, single node, or no rotation
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Step 1: Find the length of the list and the tail
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // Step 2: Normalize k
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }
        
        // Step 3: Connect tail to head to form a cycle
        tail.next = head;
        
        // Step 4: Find the new tail (length - k - 1 steps from head)
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        
        // Step 5: Break the cycle and set new head
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
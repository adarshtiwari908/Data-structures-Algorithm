class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0); // dummy node before head
        dummy.next = head;

        ListNode prev = dummy;  // points to last node known to be unique
        ListNode current = head;

        while (current != null) {
            // Check if current is start of a duplicate sequence
            if (current.next != null && current.val == current.next.val) {
                // Skip all nodes with the same value
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Move prev's next to node after duplicates
                prev.next = current.next;
            } else {
                // No duplicates, move prev
                prev = prev.next;
            }

            // Always move current forward
            current = current.next;
        }

        return dummy.next;
    }
}

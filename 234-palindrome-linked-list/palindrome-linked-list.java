class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // 1 step
            fast = fast.next.next;   // 2 steps
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalfHead = reverseList(slow);

        // Step 3: Compare the first and second half
        ListNode firstHalfPointer = head;
        ListNode secondHalfPointer = secondHalfHead;

        while (secondHalfPointer != null) {
            if (firstHalfPointer.val != secondHalfPointer.val) {
                return false;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        // Step 4 (optional): Restore the list
        // reverseList(secondHalfHead);

        return true;
    }

    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // Save next
            current.next = prev;              // Reverse pointer
            prev = current;                   // Move prev
            current = nextNode;               // Move current
        }

        return prev; // New head of reversed list
    }
}

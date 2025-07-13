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
    private int[] values;
    private Random random;
    
    public Solution(ListNode head) {
        // Count the number of nodes to size the array
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        // Initialize array and store node values
        values = new int[count];
        current = head;
        for (int i = 0; i < count; i++) {
            values[i] = current.val;
            current = current.next;
        }
        
        // Initialize Random object
        random = new Random();
    }
    
    public int getRandom() {
        // Return a random value from the array
        return values[random.nextInt(values.length)];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
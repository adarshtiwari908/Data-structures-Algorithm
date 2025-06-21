class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // Step 1: Create all new nodes and store in map
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Step 2: Set next and random pointers
        current = head;
        while (current != null) {
            Node copy = map.get(current);
            copy.next = map.get(current.next);       // may be null
            copy.random = map.get(current.random);   // may be null
            current = current.next;
        }

        // Step 3: Return the head of the copied list
        return map.get(head);
    }
}

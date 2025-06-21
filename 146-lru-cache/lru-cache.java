class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head, tail; // Dummy nodes for doubly linked list
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        // Initialize dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // Move to head (most recently used)
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            // Update value and move to head
            node.value = value;
            moveToHead(node);
        } else {
            // Create new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            // Check if over capacity
            if (cache.size() > capacity) {
                // Remove least recently used (tail.prev)
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
        }
    }
    
    // Helper: Move node to head (most recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    
    // Helper: Remove node from doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Helper: Add node right after head
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
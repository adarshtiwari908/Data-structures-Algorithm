class MyHashMap {
    private final int SIZE = 1000;
    private final LinkedList<Node>[] map;

    private static class Node {
        int key, value;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null)
            map[index] = new LinkedList<>();

        for (Node node : map[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }

        map[index].add(new Node(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        if (map[index] == null) return -1;

        for (Node node : map[index]) {
            if (node.key == key) return node.value;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (map[index] == null) return;

        map[index].removeIf(node -> node.key == key);
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
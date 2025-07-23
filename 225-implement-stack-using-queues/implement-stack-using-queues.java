class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    // Push element onto stack
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();

        // Rotate the queue to bring the new element to front
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    // Removes the top element
    public int pop() {
        return queue.poll();
    }

    // Get the top element
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty
    public boolean empty() {
        return queue.isEmpty();
    }
}

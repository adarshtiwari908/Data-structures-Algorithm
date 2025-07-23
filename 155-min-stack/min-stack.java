class MinStack {
    private Stack<Integer> stack; // Main stack for storing elements
    private Stack<Integer> minStack; // Stack to track minimums

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // Push to minStack if it's empty or val is less than or equal to current minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        // If popped element is the current minimum, remove it from minStack
        if (!stack.isEmpty() && stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
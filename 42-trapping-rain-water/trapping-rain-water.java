class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            // While current bar is higher than the top of the stack
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop(); // the valley

                if (stack.isEmpty()) break;

                int left = stack.peek(); // the left boundary
                int width = i - left - 1;
                int boundedHeight = Math.min(height[i], height[left]) - height[bottom];
                water += width * boundedHeight;
            }
            stack.push(i);
        }

        return water;
    }
}

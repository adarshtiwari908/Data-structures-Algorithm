class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();  // stores indices

        for (int i = 0; i < n; i++) {
            // If current temperature is warmer than the last stored one, update answers
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();  // get index of previous cooler day
                answer[prevDay] = i - prevDay;  // how many days until a warmer temp
            }
            stack.push(i);  // store current day's index
        }

        return answer;
    }
}

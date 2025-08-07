class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack is empty when we see a closing bracket → invalid
                if (stack.isEmpty()) return false;

                // Pop the last opening bracket
                char top = stack.pop();

                // Check if it matches the current closing bracket
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // At the end, if stack is not empty → some brackets are unmatched
        return stack.isEmpty();
    }
}

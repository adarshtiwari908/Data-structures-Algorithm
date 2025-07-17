public class Solution {
    public int myAtoi(String s) {
        // Step 1: Handle null or empty string
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        // Step 2: Initialize variables
        int index = 0;
        int sign = 1;
        long result = 0; // Use long to detect overflow before casting to int
        int n = s.length();
        
        // Step 3: Skip leading whitespace
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        
        // Step 4: Handle sign
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }
        
        // Step 5: Parse digits
        while (index < n && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');
            
            // Step 6: Check for overflow
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            index++;
        }
        
        // Step 7: Return final result with sign
        return (int) (result * sign);
    }
}
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes (centered at i)
            int len1 = expandAroundCenter(s, i, i);
            // Check for even-length palindromes (centered between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);
            // Get the maximum length of the two
            int len = Math.max(len1, len2);
            
            // Update start and maxLength if current palindrome is longer
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        // Expand around the center while characters match and indices are valid
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }
}
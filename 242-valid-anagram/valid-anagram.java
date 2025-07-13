class Solution {
    public boolean isAnagram(String s, String t) {
        // Check if lengths are different
        if (s.length() != t.length()) return false;
        
        // Array to store frequency of characters (lowercase a-z)
        int[] freq = new int[26];
        
        // Count frequencies in s and t simultaneously
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++; // Increment for s
            freq[t.charAt(i) - 'a']--; // Decrement for t
        }
        
        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0) return false;
        }
        
        return true;
    }
}
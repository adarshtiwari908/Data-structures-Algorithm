class Solution {
    public boolean isAnagram(String s, String t) {
        // Step 1: Check if lengths are different
        if (s.length() != t.length()) {
            return false;
        }
        
        // Step 2: Create frequency array for 26 lowercase letters
        int[] freq = new int[26];
        
        // Step 3: Count frequencies in s and t
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++; // Increment for s
            freq[t.charAt(i) - 'a']--; // Decrement for t
        }
        
        // Step 4: Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}
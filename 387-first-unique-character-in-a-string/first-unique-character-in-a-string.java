public class Solution {
    public int firstUniqChar(String s) {
        // Step 1: Create frequency map for characters
        int[] freq = new int[26];
        
        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Step 2: Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        // No unique character found
        return -1;
    }
}
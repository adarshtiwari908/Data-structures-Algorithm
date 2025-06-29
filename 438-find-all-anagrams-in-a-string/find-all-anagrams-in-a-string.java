class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s.length() < p.length()) {
            return result;
        }
        
        int[] pCount = new int[26];
        int[] windowCount = new int[26];
        
        // Count frequency of characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        
        int windowSize = p.length();
        
        // Initialize first window
        for (int i = 0; i < windowSize; i++) {
            windowCount[s.charAt(i) - 'a']++;
        }
        
        // Check if first window is an anagram
        if (Arrays.equals(pCount, windowCount)) {
            result.add(0);
        }
        
        // Slide the window
        for (int i = windowSize; i < s.length(); i++) {
            // Add new character to window
            windowCount[s.charAt(i) - 'a']++;
            
            // Remove character going out of window
            windowCount[s.charAt(i - windowSize) - 'a']--;
            
            // Check if current window is an anagram
            if (Arrays.equals(pCount, windowCount)) {
                result.add(i - windowSize + 1);
            }
        }
        
        return result;
    }
}
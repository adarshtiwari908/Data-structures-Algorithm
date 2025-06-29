class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Add current character to window
            count[s.charAt(right) - 'A']++;
            
            // Update max frequency of any character in current window
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            
            // If window size - max frequency > k, shrink window
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
                // Note: We don't update maxCount here for optimization
                // It's safe because we only care about finding a larger window
            }
            
            // Update maximum length found
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
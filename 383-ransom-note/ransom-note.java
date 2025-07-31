class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Array to store frequency of each character in magazine
        int[] count = new int[26];

        // Count each character in magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if ransomNote can be formed
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false; // Not enough of char c
            }
        }

        return true;
    }
}

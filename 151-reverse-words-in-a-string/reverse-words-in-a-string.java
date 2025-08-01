class Solution {
    public String reverseWords(String s) {
        // Trim leading and trailing spaces
        s = s.trim();

        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        int j = i;

        while (i >= 0) {
            // Move i to the beginning of the current word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Append the word
            result.append(s.substring(i + 1, j + 1)).append(" ");

            // Skip spaces between words
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // Set j to the end of the next word
            j = i;
        }

        // Remove trailing space
        return result.toString().trim();
    }
}

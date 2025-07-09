class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0;  // pointer to write compressed characters
        int i = 0;      // pointer to read characters

        while (i < n) {
            char curr_char = chars[i];  // current character
            int count = 0;

            // Count how many times curr_char repeats
            while (i < n && chars[i] == curr_char) {
                count++;
                i++;
            }

            // Write the character
            chars[index++] = curr_char;

            // If count > 1, write the digits
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;  // final compressed length
    }
}

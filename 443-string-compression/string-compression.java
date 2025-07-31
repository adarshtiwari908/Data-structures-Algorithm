class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int index = 0;

        while (i < n) {
            char currChar = chars[i];
            int count = 0;

            while (i < n && chars[i] == currChar) {
                count++;
                i++;
            }

            chars[index++] = currChar;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}

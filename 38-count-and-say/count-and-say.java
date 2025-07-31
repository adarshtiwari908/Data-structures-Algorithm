class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String say = countAndSay(n - 1);
        String result = "";
        int i = 0;

        while (i < say.length()) {
            char ch = say.charAt(i);
            int count = 0;

            // Count repeated characters
            while (i < say.length() && say.charAt(i) == ch) {
                count++;
                i++;
            }

            result += String.valueOf(count) + ch;
        }

        return result;
    }
}

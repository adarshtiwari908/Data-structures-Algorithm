import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        String result = s;

        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(i) + s.substring(0, i);
            if (temp.compareTo(result) < 0) {
                result = temp;
            }
        }

        return result;
    }
}

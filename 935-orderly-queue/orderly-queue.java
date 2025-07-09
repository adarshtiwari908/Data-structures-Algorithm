class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String min = s;
            for (int i = 1; i < s.length(); i++) {
                // rotate by moving first i characters to the end
                String rotated = s.substring(i) + s.substring(0, i);
                if (rotated.compareTo(min) < 0) {
                    min = rotated;
                }
            }
            return min;
        } else {
            // if k >= 2, just sort the string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}

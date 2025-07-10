import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        int n = s.length();

        if (n < 4 || n > 12) return result;

        for (int i = 1; i < Math.min(4, n - 2); i++) {
            for (int j = i + 1; j < i + Math.min(4, n - i - 1); j++) {
                for (int k = j + 1; k < j + Math.min(4, n - j); k++) {
                    if (k >= n) continue;

                    String part1 = s.substring(0, i);
                    String part2 = s.substring(i, j);
                    String part3 = s.substring(j, k);
                    String part4 = s.substring(k);

                    if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
                        result.add(part1 + "." + part2 + "." + part3 + "." + part4);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}

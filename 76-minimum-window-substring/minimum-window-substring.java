class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray())
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);

        int required = targetMap.size();
        int left = 0, right = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();

        int[] ans = {-1, 0, 0};  // {window length, left, right}

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (targetMap.containsKey(c) &&
                windowCounts.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                char d = s.charAt(left);
                windowCounts.put(d, windowCounts.get(d) - 1);
                if (targetMap.containsKey(d) &&
                    windowCounts.get(d).intValue() < targetMap.get(d).intValue()) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
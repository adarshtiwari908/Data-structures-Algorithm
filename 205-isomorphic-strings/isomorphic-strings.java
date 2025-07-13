class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> mapped = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                // Already mapped: must match current character in t
                if (map.get(c1) != c2) return false;
            } else {
                // Not mapped yet: make sure c2 isn't already mapped to some other c1
                if (mapped.contains(c2)) return false;

                map.put(c1, c2);
                mapped.add(c2);
            }
        }

        return true;
    }
}

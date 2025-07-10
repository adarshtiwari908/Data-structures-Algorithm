class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;

            while (j < words.length && (lineLen + words[j].length() + (j - i)) <= maxWidth) {
                lineLen += words[j].length();
                j++;
            }
            
            int spaces = maxWidth - lineLen;
            int numberOfWords = j - i;
            StringBuilder sb = new StringBuilder();

            if (j == words.length || numberOfWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k != j - 1) sb.append(" ");
                }
                int remainingSpaces = maxWidth - sb.length();
                while (remainingSpaces-- > 0) sb.append(" ");
            } else {
                int evenSpaces = spaces / (numberOfWords - 1);
                int extraSpaces = spaces % (numberOfWords - 1);
                
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k != j - 1) {
                        for (int s = 0; s < evenSpaces; s++) sb.append(" ");
                        if (extraSpaces > 0) {
                            sb.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            
            result.add(sb.toString());
            i = j;
        }
        
        return result;
    }
}

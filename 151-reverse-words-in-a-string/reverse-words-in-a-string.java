class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int i = 0;
        StringBuilder result = new StringBuilder();

        while(i < n){
            while( i < n && s.charAt(i) == ' ') i++;
            if (i >= n) break;
            int j = i + 1;
            while( j < n && s.charAt(j) != ' ')j++;
            String sub = s.substring(i, j);
            if (result.length() == 0) {result.append(sub);}
            else result.insert(0, sub + " ");
            i = j + 1;
        }
        return result.toString();
    }
}
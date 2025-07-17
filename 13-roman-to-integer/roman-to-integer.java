public class Solution {
    public int romanToInt(String s) {
        // Map of Roman numeral values
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        int result = 0;
        int prevValue = 0;
        
        // Iterate from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = romanValues.get(s.charAt(i));
            
            // If current value is greater than or equal to previous, add it
            if (currValue >= prevValue) {
                result += currValue;
            } 
            // If current value is less than previous, subtract it
            else {
                result -= currValue;
            }
            
            prevValue = currValue;
        }
        
        return result;
    }
}
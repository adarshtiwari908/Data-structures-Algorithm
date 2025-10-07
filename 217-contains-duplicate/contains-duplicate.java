import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * Checks if the array contains any duplicate elements.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        // 1. Initialize a HashSet to store unique elements
        Set<Integer> uniqueElements = new HashSet<>();

        // 2. Iterate through each number in the array
        for (int num : nums) {
            // 3. Check if the element already exists in the set
            if (uniqueElements.contains(num)) {
                // If it exists, a duplicate is found
                return true; 
            }
            
            // 4. If it's a new element, add it to the set
            uniqueElements.add(num);
        }

        // 5. If the loop completes without returning true, no duplicates were found
        return false;
    }
}
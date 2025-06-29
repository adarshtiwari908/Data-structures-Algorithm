class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int left = 0;
        int maxFruits = 0;
        
        // Sliding window approach
        for (int right = 0; right < fruits.length; right++) {
            // Add current fruit to the window
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);
            
            // If we have more than 2 types of fruits, shrink the window
            while (fruitCount.size() > 2) {
                int leftFruit = fruits[left];
                fruitCount.put(leftFruit, fruitCount.get(leftFruit) - 1);
                
                // Remove fruit type if count becomes 0
                if (fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                left++;
            }
            
            // Update maximum fruits collected
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        
        return maxFruits;
    }
}
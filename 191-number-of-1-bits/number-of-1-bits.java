public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // Clear the least significant 1 bit
            count++;
        }
        return count;
    }
}
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;         // total jumps we make
        int currentEnd = 0;    // the end of the range for the current jump
        int farthest = 0;      // farthest index we can reach in this range

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // update farthest

            if (i == currentEnd) {
                jumps++;             // we need to jump now
                currentEnd = farthest; // set new range end
            }
        }

        return jumps;
    }
}

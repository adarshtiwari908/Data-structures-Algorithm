class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Create a list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: Iterate and merge
        for (int[] interval : intervals) {
            // If list is empty or no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlap: merge with the last interval
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1], interval[1]
                );
            }
        }

        // Convert list back to array
        return merged.toArray(new int[merged.size()][]);
    }
}

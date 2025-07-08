class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] current : intervals) {
            // If result is empty OR no overlap with last interval
            if (result.isEmpty() || result.get(result.size() - 1)[1] < current[0]) {
                result.add(current);  // No overlap, add current interval
            } else {
                // Overlapping: merge with last interval
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], current[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        boolean[] visited = new boolean[n];
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int start = intervals[i][0];
            int end = intervals[i][1];
            visited[i] = true;

            boolean merged = true;

            while (merged) {
                merged = false;
                for (int j = 0; j < n; j++) {
                    if (visited[j]) continue;

                    int nextStart = intervals[j][0];
                    int nextEnd = intervals[j][1];

                    if (nextStart <= end && nextEnd >= start) {
                        start = Math.min(start, nextStart);
                        end = Math.max(end, nextEnd);
                        visited[j] = true;
                        merged = true;
                    }
                }
            }

            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);
    }
}

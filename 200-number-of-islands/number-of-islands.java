class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    sinkIslandDFS(grid, i, j); // Explore and sink the whole island
                }
            }
        }
        return numIslands;
    }

    private void sinkIslandDFS(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base case: check boundaries and if it's water ('0')
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }

        // Mark the current cell as visited/sunk by turning '1' to '0'
        grid[r][c] = '0';

        // Recursively visit all 4 neighbors
        sinkIslandDFS(grid, r + 1, c); // Down
        sinkIslandDFS(grid, r - 1, c); // Up
        sinkIslandDFS(grid, r, c + 1); // Right
        sinkIslandDFS(grid, r, c - 1); // Left
    }
}
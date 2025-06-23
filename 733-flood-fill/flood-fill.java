public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // If starting pixel is already the new color, return image
        if (image[sr][sc] == color) {
            return image;
        }
        // Call DFS with original color
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        // Check boundaries and if current pixel matches original color
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || 
            image[row][col] != originalColor) {
            return;
        }
        
        // Change current pixel to new color
        image[row][col] = newColor;
        
        // Recursively call DFS for 4-directional neighbors
        dfs(image, row - 1, col, originalColor, newColor); // Up
        dfs(image, row + 1, col, originalColor, newColor); // Down
        dfs(image, row, col - 1, originalColor, newColor); // Left
        dfs(image, row, col + 1, originalColor, newColor); // Right
    }
}
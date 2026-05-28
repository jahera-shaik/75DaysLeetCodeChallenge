class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int islandCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // When we find land, trigger a sink and increment the counter
                if (grid[r][c] == '1') {
                    islandCount++;
                    sinkIsland(grid, r, c);
                }
            }
        }
        
        return islandCount;
    }
    
    private void sinkIsland(char[][] grid, int r, int c) {
        // Boundary checks and water check
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        
        // Mark land as visited (water) to "sink" it
        grid[r][c] = '0';
        
        // Visit all 4 neighbors
        sinkIsland(grid, r + 1, c);
        sinkIsland(grid, r - 1, c);
        sinkIsland(grid, r, c + 1);
        sinkIsland(grid, r, c - 1);
    }
}
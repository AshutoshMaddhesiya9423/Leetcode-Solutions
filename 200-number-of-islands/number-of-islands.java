class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;  // only increment when we discover a new island
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        int rows = grid.length, cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0' || visited[r][c])
            return;

        visited[r][c] = true;

        dfs(grid, visited, r - 1, c); // up
        dfs(grid, visited, r + 1, c); // down
        dfs(grid, visited, r, c - 1); // left
        dfs(grid, visited, r, c + 1); // right
    }
}

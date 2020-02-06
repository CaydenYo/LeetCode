package UnionFind;

public class NumIslands200DFS {
    private void dfs(char[][] grid, int r, int c){
        int gr = grid.length;
        int gc = grid[0].length;

        if (r < 0 || c < 0 || r >= gr || c >= gc || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int island_count = 0;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == '1'){
                    ++island_count;
                    dfs(grid, i, j);
                }
            }
        }

        return island_count;
    }
}

package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/25 4:49 下午
 */
public class MaxAreaOfIsland695 {
    int res = 0;
    int[][] grid;
    final int[] X = {-1, 1, 0, 0};
    final int[] Y = {0, 0, -1, 1};
    int sum = 0;
    public int maxAreaOfIsland(int[][] grid){
        int row = grid.length;
        if (grid == null || row == 0){
            return 0;
        }
        int col = grid[0].length;
        if (col == 0){
            return 0;
        }
        this.grid = grid;
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                if (grid[i][j] == 1){
                    dfs(i, j);
                }
                sum = 0;
            }
        }
        return res;
    }

    private void dfs(int i, int j) {
        if (grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        sum += 1;
        res = Math.max(res, sum);
        for (int k = 0;k < 4;k++){
            int new_x = i + X[k];
            int new_y = j + Y[k];
            if (new_x >= 0 && new_x < grid.length && new_y >= 0 && new_y < grid[0].length){
                dfs(i + X[k], j + Y[k]);
            }
        }
    }

    public int maxAreaOfIsland1(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;

    }
}

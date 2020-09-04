package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/4 12:27 下午
 */
public class NumIslands200 {
    private int count = 0;
    private char[][] grid;
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid){
        count = 0;
        this.grid = grid;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == '1'){
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j){
        if (grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        for (int k = 0;k < direction.length;k++){
            int newI = i + direction[k][0];
            int newJ = j + direction[k][1];
            if (newI >= 0 && newI < grid[0].length && newJ >= 0 && newJ < grid[0].length){
                dfs(newI, newJ);
            }
        }
    }

    class UnionFind{
        private int count;
        private int[] parent;
        private int[] rank;

        public UnionFind(char[][] grid){
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0;i < m;i++){
                for (int j = 0;j < n;j++){
                    if (grid[i][j] == '1'){
                        ++count;
                        parent[i * n + j] = i * n + j;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i){
            while (i != parent[i]){
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j){
            int parentI = find(i);
            int parentJ = find(j);
            if (parentI != parentJ){
                if (rank[parentI] > rank[parentJ]){
                    parent[parentJ] = parentI;
                }else if (rank[parentI] < rank[parentJ]){
                    parent[parentI] =parentJ;
                }else {
                    parent[parentJ] = parentI;
                    rank[parentI] += 1;
                }
                --count;
            }
        }

        public int getCount(){
            return this.count;
        }
    }

    public int numIslands1(char[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        int gr = grid.length;
        int gc = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0;i < gr;i++){
            for (int j = 0;j < gc;j++){
                if (grid[i][j] == '1'){
                    grid[i][j] = '0';
                    /**
                     * 这里在union后不改变grid[i][j]的值是因为这不是dfs
                     * 改变值会导致岛的割裂
                     * */
                    if (i - 1 >= 0 && grid[i - 1][j] == '1'){
                        uf.union(i * gc + j, (i - 1) * gc + j);
                    }
                    if (i < gr - 1 && grid[i + 1][j] == '1'){
                        uf.union(i * gc + j, (i + 1) * gc + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1'){
                        uf.union(i * gc + j, i * gc + j - 1);
                    }
                    if (j < gc - 1 && grid[i][j + 1] == '1'){
                        uf.union(i * gc + j, i * gc + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}

package UnionFind;

public class NumIslands200UnionFind {
    class UnionFind{
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid){
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0;i < m;i++){
                for (int j = 0;j < n;j++){
                    if (grid[i][j] == '1'){
                        parent[i * n + j] = i * n + j;
                        ++count;
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

        public void union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty){
                if (rank[rootx] > rank[rooty]){
                    parent[rooty] = rootx;
                }else if (rank[rootx] < rank[rooty]){
                    parent[rootx] = rooty;
                }else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount(){
            return count;
        }
    }

    public int numIslands(char[][] grid){
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
                    if (i - 1 >= 0 && grid[i - 1][j] == '1'){
                        uf.union(i * gc + j, (i - 1) * gc + j);
                    }
                    if (i + 1 < gr && grid[i + 1][j] == '1'){
                        uf.union(i * gc + j, (i + 1) * gc + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1'){
                        uf.union(i * gc + j, i * gc + j - 1);
                    }
                    if (j + 1 < gc && grid[i][j + 1] == '1'){
                        uf.union(i * gc + j, i * gc + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}

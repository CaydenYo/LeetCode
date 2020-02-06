package UnionFind;

import java.util.HashSet;
import java.util.Set;

public class NumIslands200myUnionFind {
    public class UnionFind{
        private int[] parent;
        private int[] size;
        private int count;

        public UnionFind(int n){
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0;i < n;i++){
                parent[i] = i;
                size[i] = i;
            }
        }

        public int find(int p){
            while (p != parent[p]){
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ){
                return;
            }

            if (size[rootP] < size[rootQ]){
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        UnionFind uf = new UnionFind(n * m);
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if (grid[i][j] == '1'){
                    int[] neighbours = neighbours(n, m, i, j);
                    for (int item : neighbours){
                        if (item != -1){
                            int[] xy = IntToxy(n, m, item);
                            if (grid[xy[0]][xy[1]] == '1'){
                                uf.union(xyTo1D(m,i, j), item);
                            }
                        }
                    }
                }
            }
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if (grid[i][j] == '1'){
                    hashSet.add(uf.find(xyTo1D(m,i, j)));
                }
            }
        }
        return hashSet.size();
    }

    public int[] neighbours(int n, int m, int row, int col){
        int[] neighbours = {-1, -1, -1, -1};
        // top
        if (row > 0){
            neighbours[0] = xyTo1D(m, row - 1, col);
        }
        // bottom
        if (row != n - 1){
            neighbours[1] = xyTo1D(m, row + 1, col);
        }
        // left
        if (col > 0){
            neighbours[2] = xyTo1D(m, row, col - 1);
        }
        // right
        if (col != m - 1){
            neighbours[3] = xyTo1D(m, row, col + 1);
        }

        return neighbours;
    }

    // convert integer position into x, y
    private int[] IntToxy(int n, int m, int pos){
        int[] xy = {pos / m, pos % m};
        return  xy;
    }

    private int xyTo1D(int m, int row, int col){
        return m * row + col;
    }

    public static void main(String[] args){
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new NumIslands200myUnionFind().numIslands(grid));
    }

}

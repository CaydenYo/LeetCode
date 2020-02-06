package UnionFind;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands200BFS {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }

        int gr = grid.length;
        int gc = grid[0].length;
        int island_count = 0;
        for (int i = 0;i < gr;i++){
            for (int j = 0;j < gc;j++){
                if (grid[i][j] == '1'){
                    ++island_count;
                    grid[i][j] = '0'; // mark as visited
                    Queue<Integer> neighbours = new LinkedList<>();
                    neighbours.add(i * gc + j);
                    while (!neighbours.isEmpty()){
                        int id = neighbours.poll();
                        int r = id / gc;
                        int c = id % gc;
                        if (r - 1 >= 0 && grid[r - 1][c] == '1'){
                            neighbours.add((r - 1) * gc + c);
                            grid[r - 1][c] = '0';
                        }
                        if (r + 1 < gr && grid[r + 1][c] == '1'){
                            neighbours.add((r + 1) * gc + c);
                            grid[r + 1][c] = '0';
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1'){
                            neighbours.add(r * gc + c - 1);
                            grid[r][c - 1] = '0';
                        }
                        if (c + 1 < gc && grid[r][c + 1] == '1'){
                            neighbours.add(r * gc + c + 1);
                            grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return island_count;
    }
}

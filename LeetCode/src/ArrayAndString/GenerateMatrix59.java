package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/20 6:45 下午
 */
public class GenerateMatrix59 {
    public int[][] generateMatrix(int n){
        int[][] ans = new int[n][n];
        int R = n, C = n;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 1; i <= R * C; i++) {
            ans[r][c] = i;
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
}

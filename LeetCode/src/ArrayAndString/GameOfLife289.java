package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/22 8:31 下午
 */
public class GameOfLife289 {
    /**
     * 由于每个位置的细胞的状态是取决于当前四周其他细胞的状态
     * 且每个细胞的状态是同时变化的，所以不能一个一个地更新
     * 一种方法就是在一个新的数组里创建新的状态
     * 但这道题的输入是int[][]，且只有0和1，原有的最低位存储的是当前状态
     * 可以利用多出来的的比特位来储存更新后的状态
     * 只要将最后一位删除就可以得到最新的状态
     * */
    private static final int[] DX = {0, 0, 1, -1, 1, 1, -1, -1};
    private static final int[] DY = {1, -1, 0, 0, 1, -1, 1, -1};
    public void gameOfLife(int[][] board){
        if (board.length == 0){
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                int cnt = 0;
                for (int k = 0;k < 8;k++){
                    int x = i + DX[k];
                    int y = j + DY[k];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                        continue;
                    }
                    // 这里不能直接加board[x][y]是因为用了比原来多的bit位后，board[x][y]的倒数第二位是可能有值的
                    cnt += board[x][y] & 1;
                }
                if ((board[i][j] & 1) > 0){
                    // 这是个活细胞
                    if (cnt >= 2 && cnt <= 3){
                        // 周围有2/3个活细胞，下一个状态还是活细胞
                        board[i][j] = 0b11;
                    }
                    // 周围活细胞过多或者过少都会死，因为原数据是0b01，所以这里不用额外赋值
                }else if (cnt == 3){
                    // 这是个死细胞且周围有3个活细胞，下一个状态变成活细胞
                    board[i][j] = 0b10;
                }
            }
        }

        // 去掉最后一位，倒数第二位变为更新后的状态
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                board[i][j] >>= 1;
            }
        }
    }
}

package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/29 11:25 上午
 */
public class Exist79 {
    private boolean ifExist = false;
    public boolean exist(char[][] board, String word){
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    backtrack(board, visited, i, j, "" + board[i][j], word);
                    if (ifExist){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return ifExist;
    }

    private void backtrack(char[][] board, boolean[][] visited, int i, int j, String curr, String word){
        if (ifExist || curr.charAt(curr.length() - 1) != word.charAt(curr.length() - 1)){
            return;
        }
        if (curr.equals(word)){
            ifExist = true;
            return;
        }
        /**
         * 耗时久的原因分析：
         * 由于这里只要求找到一条路径符合要求即可，
         * 所以只要找到一条路径我们就应该返回，不需要再遍历其他方向
         * 而这种四个if的写法就算找到了路径也必然会走四个方向，因此耗时久
         * */
        // i - 1
        if (i > 0 && !visited[i - 1][j]){
            visited[i - 1][j] = true;
            backtrack(board, visited, i - 1, j, curr + board[i - 1][j], word);
            visited[i - 1][j] = false;
        }

        // i + 1
        if (i < board.length - 1 && !visited[i + 1][j]){
            visited[i + 1][j] = true;
            backtrack(board, visited, i + 1, j, curr + board[i + 1][j], word);
            visited[i + 1][j] = false;
        }
        // j - 1
        if (j > 0 && !visited[i][j - 1]){
            visited[i][j - 1] = true;
            backtrack(board, visited, i, j - 1, curr + board[i][j - 1], word);
            visited[i][j - 1] = false;
        }
        // j + 1
        if (j < board[0].length - 1 && !visited[i][j + 1]){
            visited[i][j + 1] = true;
            backtrack(board, visited, i , j + 1, curr + board[i][j + 1], word);
            visited[i][j + 1] = false;
        }
    }

    /**
     * 因为只要求找到路径就行(存在一条即可)，所以可以把回溯函数的返回类型从void设成boolean
     * 这样做的原因是只要回溯函数中产生了true的返回值，我们直接就可以在外面接收到这个值并且直接得到答案
     * 并且在这种方向问题上我们可以使用一个二维数组来存放转向的操作，
     * 一来是可以使用循环来简洁代码
     * 二来是每次只进行一次回溯，如果得到答案就直接返回，后面的操作不需要再做。
     * */

    private boolean[][] marked;
    private int[][] direction = {{-1, 0},{0, -1},{0, 1},{1, 0}};
    private int m;
    private int n;
    private String word;
    private char[][] board;

    public boolean exist1(char[][] board, String word){
        m = board.length;
        if (m == 0){
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (dfs(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start){
        if (start == word.length() - 1){
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)){
            marked[i][j] = true;
            for (int k = 0;k < 4;k++){
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if ((newX >= 0 && newX < m && newY >= 0 && newY < n) && !marked[newX][newY]){
                    if (dfs(newX, newY, start + 1)){
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'},{'A', 'A', 'A'},{'B', 'C', 'D'}};
        System.out.println(new Exist79().exist(board, "AAB"));
    }
}

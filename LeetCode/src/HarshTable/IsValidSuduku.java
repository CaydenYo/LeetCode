package HarshTable;

import java.util.HashMap;
import java.util.HashSet;

public class IsValidSuduku {
    public IsValidSuduku(char[][] board){
        System.out.println(isValidSudoku(board));
    }

    private boolean isValidSudoku(char[][] board) {
        // 总共有9行9列以及9个小宫
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] columns = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];

        for (int i = 0;i < 9;i++){
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0;i < 9;i++){
            for (int j = 0;j < 9;j++){
                char num = board[i][j];
                if (num != '.'){
                    int n = (int) num;
                    int box = (i / 3) * 3 + j / 3;
                    if (rows[i].contains(n) || columns[j].contains(n) || boxes[box].contains(n)){
                        return false;
                    }else {
                        rows[i].add(n);
                        columns[j].add(n);
                        boxes[box].add(n);
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidSuduku1(char[][] board){
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}

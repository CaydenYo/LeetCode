package BackTracking;

import java.util.HashSet;

public class SudokuSolver {
    // there are 9 rows, column and subboxes in total
    HashSet<Integer>[] rows = new HashSet[9];
    HashSet<Integer>[] columns = new HashSet[9];
    HashSet<Integer>[] boxes = new HashSet[9];
    char[][] board;
    boolean sudokuSolved = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0;i < 9;i++){
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        // initialize
        for (int i = 0;i < 9;i++){
            for (int j = 0;j < 9;j++){
                char num = board[i][j];
                if (num != '.'){
                    int n = Character.getNumericValue(num);
//                    int boxIndex = i / 3 * 3 + j / 3;
//                    rows[i].add(n);
//                    columns[j].add(n);
//                    boxes[boxIndex].add(n);
                    placeNum(i, j, n);
                }
            }
        }

        backtrack(0, 0);

    }

    private void backtrack(int row, int col){
        if (board[row][col] == '.'){
            for (int i = 1;i <= 9;i++){
                if (isSafe(row, col, i)){
                    placeNum(row, col, i);
                    placeNextNum(row, col);
                    if (!sudokuSolved){
                        removeNum(row, col, i);
                    }
                }
            }
        }else {
            placeNextNum(row, col);
        }
    }

    private void placeNum(int row, int col, int num){
        int boxIndex = row / 3 * 3 + col / 3;
        board[row][col] = (char)(num + '0');
        rows[row].add(num);
        columns[col].add(num);
        boxes[boxIndex].add(num);
    }

    private void placeNextNum(int row, int col){
        if ((col == 8) && (row == 8)){
            sudokuSolved = true;
        }else {
            if (col == 8){
                backtrack(row + 1, 0);
            }else {
                backtrack(row, col + 1);
            }
        }
    }

    private void removeNum(int row, int col, int num){
        int boxIndex = row / 3 * 3 + col / 3;
        board[row][col] = '.';
        rows[row].remove(num);
        columns[col].remove(num);
        boxes[boxIndex].remove(num);
    }

    private boolean isSafe(int row, int col, int num){
        if (rows[row].contains(num)
                || columns[col].contains(num)
                || boxes[row / 3 * 3 + col / 3].contains(num)){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new SudokuSolver().solveSudoku(board);
        for (char[] item : board){
            for (int i = 0;i < item.length;i++){
                System.out.print(item[i] + " ");
            }
            System.out.println(" ");
        }
    }
}

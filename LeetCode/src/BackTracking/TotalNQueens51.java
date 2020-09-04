package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class TotalNQueens51 {
    private List<List<String>> output = new ArrayList<>();
    private int res = 0;
    // mark if columns are under attacked
    int[] rows;
    // mark if main diagonals are under attacked
    int[] mainDiagonals;
    // mark if secondary diagonals are under attacked
    int[] secondaryDiagonals;
    // place queen position
    int[] queen;

    int n;

    public List<List<String>> solveNQueens(int n) {
        // initialize
        rows = new int[n];
        mainDiagonals = new int[2 * n - 1];
        secondaryDiagonals = new int[2 * n - 1];
        queen = new int[n];
        this.n = n;

        // backtrack from row index = 0
        backtrack(0);

        return output;
    }

    private void backtrack(int row) {
        if (row >= n){
            return;
        }
        for (int j = 0;j < n;j++){
            if (is_not_under_attack(row, j)) {
                placeQueen(row, j);
                if (row + 1 == n) {
                    addSolution();
                    res += 1;
                }
                backtrack(row + 1);
                removeQueen(row, j);
            }
        }
    }

    private boolean is_not_under_attack(int row, int col){
        return (rows[col] + mainDiagonals[row - col + n - 1] + secondaryDiagonals[row + col]) == 0 ? true : false;
    }

    private void placeQueen(int row, int col){
        queen[row] = col;
        rows[col] = 1;
        mainDiagonals[row - col + n - 1] = 1;
        secondaryDiagonals[row + col] = 1;
    }

    private void removeQueen(int row, int col){
        queen[row] = 0;
        rows[col] = 0;
        mainDiagonals[row - col + n - 1] = 0;
        secondaryDiagonals[row + col] = 0;
    }

    private void addSolution(){
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = queen[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j < n;j++){
                if (j == col){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            solution.add(sb.toString());
        }
        output.add(solution);
    }
}

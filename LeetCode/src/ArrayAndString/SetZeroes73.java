package ArrayAndString;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/8/20 6:54 下午
 */
public class SetZeroes73 {
    int[][] matrix;
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    public void setZeroes(int[][] matrix){
        this.matrix = matrix;
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[0].length;j++){
                if (matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int row : rows){
            for (int j = 0;j < matrix[0].length;j++){
                matrix[row][j] = 0;
            }
        }

        for (int col : cols){
            for (int i = 0;i < matrix.length;i++){
                matrix[i][col] = 0;
            }
        }
    }

    /**
     * 遍历整个矩阵，如果当前元素(x,y)为0，
     * 则将对应的第一行(0, y)和第一列(x, 0)置为0
     * 最后将第一行和第一列为0的对应行和列都赋值为0即可
     * */
    public void setZeroes2(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}

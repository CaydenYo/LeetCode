package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/25 10:17 下午
 */
public class Rotate48 {
    // 先转置矩阵，然后翻转每一行
    public void rotate(int[][] matrix){
        int n = matrix.length;
        // 转置
        for (int i = 0;i < n;i++){
            for (int j = i;j < n;j++){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        // 翻转
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n / 2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public void rotate1(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < (n >> 1); ++i){
            for(int j = i; j < n - 1 - i; ++j){
                swap(matrix[i][j], matrix[j][n - 1 - i]);
                swap(matrix[i][j], matrix[n - 1 - i][n - 1 - j]);
                swap(matrix[i][j], matrix[n - 1 - j][i]);
            }
        }
    }

    private void swap(int matrix1, int matrix2) {
        // swap two values in matrix
    }
}

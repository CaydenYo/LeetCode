package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/24 6:11 下午
 */
public class ImageSmoother661 {
    public int[][] imageSmoother(int[][] M){
        if (M == null){
            return null;
        }
        int rows = M.length;
        if (rows == 0){
            return new int[0][];
        }
        int cols = M[0].length;

        int result[][] = new int[rows][cols];

        for (int i = 0;i < rows;i++){
            for (int j = 0;j < cols;j++){
                int count = 0;
                int sum = 0;
                for (int x : new int[]{-1, 0, 1}){
                    for (int y : new int[]{-1, 0, 1}){
                        if (isValid(i + x, j + y, rows, cols)){
                            count++;
                            sum += M[i + x][j + y];
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}

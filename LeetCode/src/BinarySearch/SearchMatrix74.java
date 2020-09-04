package BinarySearch;

/**
 * @Author cayden
 * @Date 2020/8/15 12:45 上午
 */
public class SearchMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target){
        int row = matrix.length;
        if (row == 0){
            return false;
        }
        int col = matrix[0].length;
        if (col == 0){
            return false;
        }
        for (int i = 0;i < row;i++){
            if (target <= matrix[i][col - 1]){
                int low = 0, high = col - 1;
                while (low <= high){
                    int mid = low + (high - low) / 2;
                    if (matrix[i][mid] == target){
                        return true;
                    }else if(matrix[i][mid] < target){
                        low = mid + 1;
                    }else {
                        high = mid - 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}

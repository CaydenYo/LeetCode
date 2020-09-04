package Recursion;

public class SearchMatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    public boolean searchMatrixRecursion(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int shortDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0;i < shortDim;i++){
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound){
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical){
        int low = start;
        int high = vertical ? matrix[0].length : matrix.length;

        while (high >= low){
            int mid = low + (high - low) / 2;
            if (vertical){
                if (matrix[start][mid] == target){
                    return true;
                }else if (matrix[start][mid] < target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }else {
                if (matrix[mid][start] == target){
                    return true;
                }else if (matrix[mid][start] < target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}

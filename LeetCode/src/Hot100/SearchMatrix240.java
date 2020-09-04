package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/8 5:04 下午
 */
public class SearchMatrix240 {
    /**
     * 因为矩阵从左到右递增，从上到下递增
     * 对于每个左下角元素来说，
     * 它是当前行的最小值，是当前列的最大值
     * 所以如果target比它小的话，表示target不可能在这个元素的所在行，行数减一
     * 如果target比它大，表示target不可能在这个元素的所在列，列数减一
     * */
    public boolean searchMatrix(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0){
            return false;
        }
        return searchMatrix(matrix, matrix.length, matrix[0].length, target);
    }

    private boolean searchMatrix(int[][] matrix, int m, int n, int target){
        if (m == 0 || n == 0){
            return false;
        }
        int aim = matrix[m - 1][matrix[0].length - n];
        if (aim == target){
            return true;
        }

        if (aim < target){
            return searchMatrix(matrix, m, n - 1, target);
        }else {
            return searchMatrix(matrix, m - 1, n, target);
        }
    }

    /**
     * 对每一行进行二分查找，行数为m，列数为n
     * 其中每一行的二分查找时间为O(logn)
     * 对m行进行二分查找就是O(mlogn)
     * */
    public boolean searchMatrix1(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int low = 0, high = matrix[0].length;
        for (int[] raw : matrix){
            if (binarySearch(raw, low, high - 1, target)){
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] raw, int low, int high, int target){
        if (low > high){
            return false;
        }
        int mid = low + (high - low) / 2;
        if (raw[mid] == target){
            return true;
        }
        if (raw[mid] > target){
            return binarySearch(raw, low, mid - 1, target);
        }else {
            return binarySearch(raw, mid + 1, high, target);
        }
    }

    /**
     * 利用对角线迭代二分法
     * */
    public boolean searchMatrix2(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int shortDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0;i < shortDim;i++){
            boolean verticalFound = binarySearch1(matrix, target, i, true);
            boolean horizontalFound = binarySearch1(matrix, target, i, false);
            if (verticalFound || horizontalFound){
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch1(int[][] matrix, int target, int start, boolean isVertical) {
        int low = start;
        int high = isVertical ? matrix[0].length - 1 : matrix.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if (isVertical){
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



    /**
     * 左上角为矩阵最小值，右下角为矩阵最大值
     * 每次二分选取中间一列，从上往下遍历，
     * 假如当前元素小于target，
     * 那么以这个元素为右下角的矩阵不可能包含target，于是往下遍历，此时已经舍弃掉左上角矩阵
     * 来到下一个元素，如果当前元素大于target
     * 那么以这个元素为左上角的矩阵不可能包含target，因此舍弃右下角的矩阵（至此舍弃了两个矩阵）
     * 剩下两个矩阵无法判断，因此递归剩下的两个矩阵
     * */
    private int[][] matrix;
    private int target;

    private boolean searchRec(int left, int up, int right, int down) {
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
            // `target` is already larger than the largest element or smaller
            // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = left + (right-left)/2;

        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }

        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
    }

    public boolean searchMatrix3(int[][] mat, int targ) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`
        matrix = mat;
        target = targ;

        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
    }
}

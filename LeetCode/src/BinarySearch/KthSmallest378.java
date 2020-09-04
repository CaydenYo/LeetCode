package BinarySearch;

/**
 * @Author cayden
 * @Date 2020/8/16 2:49 下午
 */
public class KthSmallest378 {
    /**
     * 这个二维矩阵中从左到右，从上到下递增
     * 那么假设一个数为x，则小于等于x的数都在这个x的左上方
     * 矩阵中的最小值在左上角，最大值在右下角，去这两个值的中间值
     * 然后从矩阵左下角开始遍历判断，如果当前的值小于等于中间值的话，
     * 则代表当前值以及当前值的左上角的所有值都小于中间值，
     * 遍历过程中直接将当前列中比当前元素小的所有元素个数加到中间结果上，并且向右判断下一列
     * 如果是大于mid的话，则需要往上面移动一行再进行判断
     * 当判断完整个矩阵后，我们要判断比mid值小的元素有多少个
     * 如果比mid值小的元素大于等于k个，证明我们要找的元素小于等于mid，因此right = mid
     * 如果比mid值打的元素小于k个，证明我们要找的元素一定大于mid，因此left = mid + 1
     * */
    public int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right){
            int mid = left + (right - left) / 2;
            if (check(matrix, mid, k, n)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n){
            // 一列一列地加
            if (matrix[i][j] <= mid){
                num += i + 1;
                j++;
            }else {
                i--;
            }
        }
        return num >= k;
    }
}

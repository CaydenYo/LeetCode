package BinarySearch;

/**
 * @Author cayden
 * @Date 2020/8/17 6:55 下午
 */
public class PeakIndexInMountainArray852 {
    public int peakIndexInMountainArray(int[] A){
        int low = 0, high = A.length - 1;
        int mid;
        while (low <= high){
            mid = low + (high - low) / 2;
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]){
                return mid;
            }else if (A[mid - 1] < A[mid]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }
}

package BinarySearch;

/**
 * @Author cayden
 * @Date 2020/8/17 12:17 上午
 */
public class ArrangeCoins441 {
    public int arrangeCoins(int n){
        long low = 0, high = n;
        while (low <= high){
            long mid = low + (high - low) / 2;
            long cost = ((mid + 1) * mid) / 2;
            if (cost == n){
                return (int)mid;
            }else if (cost > n){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return (int)high;
    }
}

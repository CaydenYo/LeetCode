package BinarySearch;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/8/17 9:50 下午
 */
public class MinEatingSpeed875 {
    /**
     * 每个小时最少吃1根，最多吃数组中的最大值
     * 每次取中间值，然后判断吃完需要多长时间
     * 如果超过了警卫离开的时间，则证明每个小时吃的太少，往右边找
     * 若小于警卫离开的时间证明每个小时吃的太多，往左边继续找
     * */
    public int minEatingSpeed(int[] piles, int H){
        int size = piles.length;
        Arrays.sort(piles);
        if (size == H){
            return piles[size - 1];
        }
        int low = 1, high = piles[size - 1];
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (canEatAll(piles, mid, H)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canEatAll(int[] piles, int mid, int H) {
        int countHour = 0;

        for (int pile : piles){
            countHour += pile / mid;
            if (pile % mid != 0){
                countHour++;
            }
        }

        return countHour <= H;
    }

}

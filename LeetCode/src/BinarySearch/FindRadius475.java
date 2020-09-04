package BinarySearch;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/8/17 1:09 上午
 */
public class FindRadius475 {
    public int findRadius(int[] houses, int[] heaters) {
        //1.对于所有的房屋，要么用前面的暖气，要么取后面的暖气，两者选最小值，得到距离
        //2.对所有的房屋，取距离的最大值
        Arrays.sort(heaters);
        int min=0;
        for(int house:houses){
            min=Math.max(min,search(heaters,house));
        }
        return min;
    }

    private int search(int [] heaters,int house){
        int left = 0;
        int right = heaters.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(house == heaters[mid]){
                return 0;
            }
            else if(house<heaters[mid]){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        if(left > heaters.length-1){
            return house - heaters[heaters.length-1];
        }
        else if(right < 0){
            return heaters[0] - house;
        }
        else{
            return Math.min((heaters[left]-house),(house-heaters[right]));
        }
    }
}

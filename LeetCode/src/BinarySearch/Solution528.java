package BinarySearch;

import java.util.Random;

/**
 * @Author cayden
 * @Date 2020/8/18 12:04 上午
 */
public class Solution528 {
    /**
     * 例如：对于w[i] = {1,3,5,6}
     * 从头开始遍历数组将权重值逐步累加获得前缀值{1,4,9,15}
     * 然后使用random产生一个[1,15]之间的随机数，
     * 如果随机数落在[1]对应元素为0，落在[2,4]对应1，落在[5,9]对应2，落在[10,15]对应3
     * 因为权重前缀和是递增的，所以可以使用二分法来寻找随机数对应的区间
     * */
    // 权重累加数组
    int[] arr;
    public Solution528(int[] w){
        arr = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            arr[i] = sum;
        }
    }

    public int pickIndex(){
        // 产生随机数
        Random random = new Random();
        int randomNum = random.nextInt(arr[arr.length - 1]) + 1;
        // 二分查找随机数所在的区间
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == randomNum){
                return mid;
            }else if (arr[mid] > randomNum){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }
}

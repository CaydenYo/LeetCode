package BinarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/16 9:51 下午
 */
public class FindRightInterval436 {
    /**
     * 寻找某一个数首先往二分查找方向想
     * 使用二分查找需要在有序的环境中进行，因此需要对区间进行排序
     * 由于题目要求返回索引，但是排序以后，索引信息丢失，因此需要提前将起点的索引的关系存起来
     * 又因题目说区间之间不具有相同的起点，因此可以使用哈希表来存储以上关系
     *
     * */
    public int[] findRightInterval(int[][] intervals){
        int len = intervals.length;
        if (len == 0){
            return new int[0];
        }
        // 对原始区间进行预处理，key:起点，value:索引
        // 题目中的区间不具有相同的起始点，所以可以用哈希表储存
        Map<Integer, Integer> hashMap = new HashMap<>();

        int[] arr = new int[len];
        int[] res = new int[len];
        for (int i = 0;i < len;i++){
            hashMap.put(intervals[i][0], i);
            arr[i] = intervals[i][0];
        }

        Arrays.sort(arr);

        for (int i = 0;i < len;i++){
            int index = binarySearch(arr, intervals[i][1]);
            if (index == -1){
                res[i] = -1;
            }else {
                res[i] = hashMap.get(arr[index]);
            }
        }

        return res;
    }

    private int binarySearch(int[] arr, int target){
        int len = arr.length;
        if (arr[len - 1] < target){
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}

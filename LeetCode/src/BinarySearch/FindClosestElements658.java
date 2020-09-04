package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements658 {
    public List<Integer> myFindClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        int minMax = -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == x){
                while(arr[mid] == x){
                    mid++;
                    right = mid;
                }
                minMax = mid - 1;
                break;
            }else if (arr[mid] > x){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        if (left == right){
            minMax = right;
        }
        if (minMax <= k - 1){
            List<Integer> res = new ArrayList<>();
            for (int i = 0;i < k;i++){
                res.add(arr[i]);
            }
            return res;
        }else {
            List<Integer> res = new ArrayList<>();
            for (int i = minMax - k + 1;i <= minMax;i++){
                res.add(arr[i]);
            }
            return res;
        }
    }

    // two pointers
    public List<Integer> FindClosestElements(int[] arr, int k, int x){
        int size = arr.length;

        int left = 0;
        int right = arr.length - 1;

        int removeNums = size - k;
        while (removeNums > 0){
            if (x - arr[left] <= arr[right] - x){
                right--;
            }else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left;i < left + k;i++){
            res.add(arr[i]);
        }
        return res;
    }

    // binary search
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - k;

        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}

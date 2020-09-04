package Hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/7/3 4:48 下午
 */
public class MajorityElement169 {
    public int majorityElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        int res = 0;
        for (int i = 0;i < nums.length;i++){
            if (map.get(nums[i]) > max){
                max = map.get(nums[i]);
                res = nums[i];
            }
        }
        return res;
    }

    /**
     * 将数组排序，众数一定是下标为n/2的数组元素
     * 因为本题众数的个数大于n/2，所以一定会覆盖下标n/2
     * */
    public int majorityElement1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     *
     * 核心就是对拼消耗。
     *
     * 玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，
     * 并且能保证每个人口出去干仗都能一对一同归于尽。最后还有人活下来的国家就是胜利。
     *
     * 那就大混战呗，最差所有人都联合起来对付你
     * （对应你每次选择作为计数器的数都是众数），
     * 或者其他国家也会相互攻击（会选择其他数作为计数器的数），
     * 但是只要你们不要内斗，最后肯定你赢。最后能剩下的必定是自己人。
     * */
    public int majorityElement2(int[] nums){
        int count = 1;
        int res = nums[0];
        for (int i = 1;i < nums.length;i++){
            if (nums[i] == res){
                count++;
            }else {
                count--;
                if (count == 0){
                    res = nums[i + 1];
                }
            }
        }
        return res;
    }

    /**
     * 分治法
     * 如果a是众数，那么我们将数组氛围两部分，a必定是至少一部分的众数
     * 如果a既不是左边的众数也不是右边的众数
     * 则a的数量小于left/2 + right/2， 即a的数量小于n/2
     * 与题意矛盾
     * */
    public int majorityElement3(int[] nums){
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int low, int high) {
        if (low == high){
            return nums[low];
        }
        int mid = low + (high - low) / 2;
        int left = binarySearch(nums, low, mid);
        int right = binarySearch(nums, mid + 1, high);

        if (left == right){
            return left;
        }

        int leftCount = countInRange(nums, left, low, mid);
        int rightCount = countInRange(nums, right, mid + 1, high);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int low, int high){
        int count = 0;
        for (int i = low;i <= high;i++){
            if (nums[i] == num){
                count++;
            }
        }
        return count;
    }

    /**
     * 找第n/2 + 1小的数
     * */
    public int majorityElement4(int[] nums) {
        return quickSearch(nums, 0, nums.length - 1, nums.length / 2);
    }

    private int quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于n/2就返回；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return nums[j];
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

}

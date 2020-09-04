package BinarySearch;

public class FindDuplicate287 {
    /**
     * 本题使用二分法的前提是因为题目中说
     * "给定一个包含n + 1个整数的数组nums，其数字都在1到n之间（包含1和n）"
     * 这个二分法是用来确定一个有范围的整数
     * 基础：抽屉原理：10个球装进9个抽屉，必定有一个抽屉有2个球或者以上
     * 因为数组里的整数规定死了，一定在1到n之间，包含1和n
     * 那么就先猜一个中间的数，例如1到7之间，先猜一个4
     * 然后循环数组统计小于等于4的元素的个数cnt，
     * 如果cnt严格大于4的话，根据抽屉原理，重复元素就在1到4之间
     * 很好理解，加入1到4没有重复元素，那就是{1,2,3,4}
     * 小于等于4的个数刚好是4个，但凡多重复一个都会严格大于4
     * */
    public int findDuplicate(int[] nums){
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums){
                if (num <= mid){
                    cnt++;
                }
            }
            if (cnt > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}

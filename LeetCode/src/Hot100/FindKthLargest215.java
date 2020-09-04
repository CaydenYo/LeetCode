package Hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author cayden
 * @Date 2020/7/6 12:48 下午
 */
public class FindKthLargest215 {
    public int findKthLargest(int[] nums, int k){
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int low, int high, int k){
        int p = partition(nums, low, high);
        if (p == nums.length - k){
            return nums[p];
        }
        if (p > nums.length - k){
            return quickSort(nums, low, p - 1, k);
        }else {
            return quickSort(nums, p + 1, high, k);
        }
    }

    private int partition(int[] nums, int low, int high){
        int base = nums[low];
        int l = low, r = high;
        while (l < r){
            while (l < r && nums[r] >= base){
                r--;
            }
            while (l < r && nums[l] <= base){
                l++;
            }

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        nums[low] = nums[l];
        nums[l] = base;
        return l;
    }

    /**
     * 小根堆和大根堆
     * 因为第K大元素，其实就是整个数组排序以后后半部分最小的那个元素
     * 因此我们可以维护一个有K个元素的最小堆：
     * 1. 如果当前堆不满，直接添加
     * 2. 堆满的时候，如果新读到的数小于等于堆顶，肯定不是我们要找的元素
     *    只有新读到的数大于堆顶时才将堆顶拿出，放入新读到的数
     * */
    public int findKthLargest1(int[] nums, int k){
        // 根据k的不同选最大堆和最小堆，目的是让堆中元素更少
        // 若k更靠近0，此时k是一个较大的数，应该使用最大堆
        // 反之若k更靠近len的话，k是一个较小的数，应该使用最小堆
        int len = nums.length;
        /**
         * 堆的大小+1是因为，到了k个以后的元素
         * 就进来一个，出去一个，
         * 我们不需要对数据做判断，让优先队列自己去维护大小关系
         * 但是耗时就会长一些
         * */
        if (k <= len - k){
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
            for (int i = 0;i < k;i++){
                minHeap.add(nums[i]);
            }

            for (int i = k;i < len;i++){
                minHeap.add(nums[i]);
                minHeap.poll();
            }
            return minHeap.peek();
        }else {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len - k + 2, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            for (int i = 0;i < len - k + 1;i++){
                maxHeap.add(nums[i]);
            }
            for (int i = len - k + 1;i < len;i++){
                maxHeap.add(nums[i]);
                maxHeap.poll();
            }
            return maxHeap.peek();
        }
    }
}

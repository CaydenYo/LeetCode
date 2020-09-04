package Hot100;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author cayden
 * @Date 2020/7/7 8:02 下午
 */
public class MaxSlidingWindow239 {
    public int [] maxSlidingWindow(int[] nums, int k){
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0;i < nums.length;i++){
            if (maxHeap.size() < k){
                maxHeap.add(nums[i]);
            }else {
                res[i - k] = maxHeap.peek();
                maxHeap.remove(nums[i - k]);
                maxHeap.add(nums[i]);
            }
        }

        return res;
    }

    /**
     * 双端队列：
     * 在一堆数字中，已知最值
     * 如果给这堆数添加一个数，那么比较一下就可以很快算出最值
     * 但如果减少一个数，就要遍历所有数重新找最值
     * 单调队列可以实现添加一个数同时减少一个数并且在O(1)时间找出新的最值
     * 我们在加入数字前，要先让这个数字和队列尾的数字作比较
     * 如果队列尾的数字小于当前数字，那么就要把这个数字移除，
     * 这是因为比当前数字还小的数字是永远不可能成为之后的最大值的，所以可以放心移除
     * 但是这里我们每遍历一个数字就要把窗口内最前面的那个数字移除
     * 如果队列里存的是数字的话我们就不知道前面被删除的数字到底是哪个下标的
     * 所以队列里应该放入下标，如果队列头的下标正是窗口内最前面数字的下标那么我们就移除队列头
     * 如果不是，那么队列头已经在上面移除小值的时候被删除了，所以跳过删除步骤
     * */
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int[] nums;

    private void clean_deque(int i, int k){
        // 先把已经不在窗口里的元素移出队列
        if (!deque.isEmpty() && deque.getFirst() == i - k){
            deque.removeFirst();
        }
        // 然后把队尾所有小于当前元素的元素移出队尾
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]){
            deque.removeLast();
        }
    }

    public int[] maxSlidingWindow1(int[] nums, int k){
        int n = nums.length;
        if (n * k == 0){
            return new int[0];
        }
        if (k == 1){
            return nums;
        }

        this.nums = nums;
        // 初始化队列
        int max_idx = 0;
        for (int i = 0;i < k;i++){
            clean_deque(i, k);
            deque.addLast(i);
            if (nums[i] > nums[max_idx]){
                max_idx = i;
            }
        }
        int[] res = new int[n - k + 1];
        res[0] = nums[max_idx];

        // 每次入队列之前先把队尾小于当前元素的元素移出(因为它们没有机会成为最大元素)
        // 这样的队列就是单调递减，队头就是当前窗口最大元素
        for (int i = k;i < nums.length;i++){
            clean_deque(i, k);
            deque.addLast(i);
            res[i - k + 1] = nums[deque.getFirst()];
        }

        return res;
    }
}

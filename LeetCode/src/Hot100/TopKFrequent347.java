package Hot100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author cayden
 * @Date 2020/7/11 5:25 下午
 */
public class TopKFrequent347 {
    /**
     * 用哈希表统计出现频率
     * 然后维护一个小根堆
     * 当堆大小小于k时，无脑插入哈希表中的元素
     * 然后再插入时就要比较当前元素和堆顶元素
     * 如果当前元素出现频率比堆顶元素高则把堆顶元素移出，添加新元素
     * */
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hashMap.get(o1) - hashMap.get(o2);
            }
        });

        for (int i : hashMap.keySet()){
            if (priorityQueue.size() < k){
                priorityQueue.add(i);
            }else if (hashMap.get(i) > hashMap.get(priorityQueue.peek())){
                priorityQueue.poll();
                priorityQueue.add(i);
            }
        }
        int[] res = new int[k];
        for (int i = 0;i < k;i++){
            res[i] = priorityQueue.poll();
        }

        return res;
    }
}

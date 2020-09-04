package ArrayAndString;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author cayden
 * @Date 2020/9/3 1:52 下午
 */
public class PartitionDisjoint915 {
    public int partitionDisjoint(int[] A){
        int res = 1;
        int max = A[0];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.add(A[0]);
        for (int i = 1;i < A.length;i++){
            if (A[i] < max){
                res = i + 1;
                max = priorityQueue.peek();
            }
            priorityQueue.add(A[i]);
        }
        return res;
    }

    /**
     * 检验max(left) <= min(right)
     * 三次遍历数组：
     * 第一次从左到右得到maxLeft数组
     * 第二次从右到左得到minRight数组
     * 第三次从左到右一旦得到max(left) <= min(right)就返回值
     * */
    public int partitionDisjoint1(int[] A){
        int N = A.length;
        int[] maxLeft = new int[N];
        int[] minRight = new int[N];

        int m = A[0];
        for (int i = 0;i < N;i++){
            m = Math.max(m, A[i]);
            maxLeft[i] = m;
        }

        m = A[N - 1];
        for (int i = N - 1;i >= 0;i--){
            m = Math.min(m, A[i]);
            minRight[i] = m;
        }

        for (int i = 1;i < N;i++){
            if (maxLeft[i - 1] <= minRight[i]){
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {32,57,24,19,0,24,49,67,87,87};
        System.out.println(new PartitionDisjoint915().partitionDisjoint(nums));
    }
}

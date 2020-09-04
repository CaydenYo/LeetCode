package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/26 8:51 下午
 */
public class MaxChunksToSorted769 {
    /**
     * 当遍历到第i个位置时，如果可以切分为块
     * 那前i个位置的最大值一定等于i
     * 否则一定有比i小的数划分到了后面的块，即排序后不满足升序
     * */
    public int maxChunksToSorted(int[] arr){
        int res = 0, max = 0;
        for (int i = 0;i < arr.length;i++){
            max = Math.max(max, arr[i]);
            if (max == i){
                res++;
            }
        }
        return res;
    }
}

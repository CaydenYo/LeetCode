package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/27 3:46 下午
 */
public class NumSubarrayBoundedMax795 {
    /**
     * 最大元素满足大于等于L小于等于R的子数组个数=
     * 最大元素小于等于R的子数组个数 - 最大元素小于L的子数组个数
     * */
    public int numSubarrayBoundedMax(int[] A, int L, int R){
        return numSubarrayBoundedMax(A, R) - numSubarrayBoundedMax(A, L - 1);
    }

    private int numSubarrayBoundedMax(int[] A, int max){
        int res = 0;
        int numSubarray = 0;
        for (int num : A){
            if (num <= max){
                numSubarray++;
                res += numSubarray;
            }else {
                numSubarray = 0;
            }
        }
        return res;
    }
}

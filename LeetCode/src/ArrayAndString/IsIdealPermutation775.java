package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/26 10:19 下午
 */
public class IsIdealPermutation775 {
    /**
     * 因为局部倒置也属于全局倒置
     * 要使局部倒置的数量等于全局倒置的数量
     * 即数组中的所有全局倒置均为局部倒置
     * 用max表示前i-2项的最大值，如果这个最大值大于第i项的话返回false
     * */
    public boolean isIdealPermutation(int[] A){
        int max = 0;
        int len = A.length;
        for (int i = 0;i < len - 2;i++){
            max = Math.max(max, A[i]);
            if (max > A[i + 1]){
                return false;
            }
        }
        return true;
    }
}

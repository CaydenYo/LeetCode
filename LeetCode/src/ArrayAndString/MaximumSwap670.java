package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/24 9:30 下午
 */
public class MaximumSwap670 {
    /**
     * 用一个数组记录数字中每一位数字最新出现的数组下标
     * 然后从左到右遍历数字数组，对于数组中的每一个元素
     * 从9开始判断，如果数组中出现了9并且它最后一次出现的数组下标大于当前元素下标
     * 那么就将它和当前元素交换，否则用8继续判断
     * */
    public int maximumSwap(int num){
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0;i < A.length;i++){
            last[A[i] - '0'] = i;
        }

        for (int i = 0;i < A.length;i++){
            for (int d = 9;d > A[i] - '0';d--){
                if (last[d] > i){
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }

        return num;
    }
}

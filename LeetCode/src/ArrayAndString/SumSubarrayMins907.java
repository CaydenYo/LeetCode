package ArrayAndString;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cayden
 * @Date 2020/8/31 11:49 上午
 */
public class SumSubarrayMins907 {
    /**
     * 假设从数组的头部遍历，
     * 1. 如果后面的数大于前面的数，那么这两个数构成的子数组取得肯定是前面的小的数
     * 2. 如果后面的数小于前面的数，那么子数组就得取后面的数
     * 其中(i - j) * （k - i)是排列组合，算出来是以A[j]为最小值的子数组的总和
     * */
    public int sumSubarrayMins(int[] A){
        int ans = 0;
        int mod = 1000000007;
        for(int i = 0;i < A.length;i++){
            long sum = 0;
            int a = A[i];
            int j = i-1;
            int k = i+1;
            for(;j >= 0;j--){
                if(A[j] < a){
                    break;
                }
            }
            for(;k < A.length;k++){
                if(A[k] <= a){
                    break;
                }
            }
            sum = a * (i - j) * (k - i) % mod;
            ans = (ans + (int)sum) % mod;
        }
        return ans;
    }

    public int sumSubarrayMins1(int[] A){
        Deque<Integer> stack = new ArrayDeque<>();
        int n = A.length, res = 0, mod = 1000000007;
        for (int i = 0;i <= n;i++){
            int cur = (i == n) ? 0 : A[i];
            while (!stack.isEmpty() && A[stack.peek()] > cur){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                res = (res + A[j] * (i - j) * (j - k)) % mod;
            }
            stack.push(i);
        }
        return res;
    }
}

package Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cayden
 * @Date 2020/7/14 10:16 下午
 */
public class DailyTemperatures739 {
    /**
     * 单调栈
     * 如果栈为空，直接将下标入栈
     * 否则比较当前元素和栈顶元素
     * 如果当前元素大于栈顶元素就把栈顶元素出栈，更新res
     * 重复上面的步骤，直到当前元素小于栈顶元素，将当前元素入栈
     * 最后栈内剩下的元素就是找不到比它温度高的元素
     * 把res对应的位置都置为0
     * */
    public int[] dailyTemperatures(int[] T){
        int len = T.length;
        if (len == 0){
            return new int[0];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[len];
        for (int i = 0;i < T.length;i++){
            if (stack.isEmpty()){
                stack.addLast(i);
            }
            while (!stack.isEmpty() && T[i] > T[stack.peekLast()]){
                int idx = stack.pollLast();
                res[idx] = i - idx;
            }
            stack.addLast(i);
        }
        // 数组初始化都为0，这里为了表达清楚逻辑，多做了一步
        while (!stack.isEmpty()){
            res[stack.pollLast()] = 0;
        }

        return res;
    }

    /**
     * 从后向前遍历
     * */
    public int[] dailyTemperatures1(int[] T){
        int n = T.length;
        int[] res = new int[n];
        for (int i = n - 2;i >= 0;i--){
            int j = i + 1;
            while (j < n){
                if (T[i] < T[j]){
                    // 找到就停止while循环
                    res[i] = j - i;
                    break;
                }else if (res[j] == 0){
                    // 如果没找到，并且res[j] == 0
                    // 说明第j个元素后面没有比第j个元素大的值
                    // 自然也不可能有比i大的值(i < j)，所以直接终结while循环
                    break;
                }else {
                    // 如果没有找到，但是res[j] != 0
                    // 说明第j个元素后面有比第j个元素大的值
                    // 我们直接往后挪res[j]个单位，比较i和这个新的值
                    j = j + res[j];
                }
            }
        }
        return res;
    }
}

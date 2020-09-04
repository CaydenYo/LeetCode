package Recursion;

/**
 * @Author cayden
 * @Date 2020/7/18 5:49 下午
 */
public class KthGrammar779 {
    /**
     * 第K个数字是上一行第(k + 1) / 2个数字生成的
     * 如果上一行数字为0，生成的数字为1 - (k % 2)
     * 如果上一行数字为1，生成的数字为k % 2
     * */
    public int kthGrammar(int N, int K){
        if (N == 1){
            return 0;
        }
        return (~K & 1) ^ kthGrammar(N - 1, (K + 1) / 2);
    }
}

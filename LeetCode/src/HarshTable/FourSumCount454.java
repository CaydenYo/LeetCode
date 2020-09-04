package HarshTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/17 12:36 下午
 */
public class FourSumCount454 {
    /**
     * 将四数相加转换成两数相加，即有三种情况
     * HashMap存一个数组，然后计算另外三个数组之和，时间复杂度O(n) + O(n³)
     * HashMap存两个数组之和，然后计算另外两个数组之和，时间负责度O(n²) + O(n²)
     * HashMap存三个数组之和，然后计算一个数组，时间复杂度O(n³) + O(n)
     *
     * 因此存两个数组的时间复杂度最低
     * 以存AB两数组之和为例，首先求出A和B任意两数之和sumAB，以sumAB为key，其出现的次数为value存入map
     * 然后计算C和D之和的相反数sumCD，在hashmap中查找是否存在key为sumCD
     * */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0;i < A.length;i++){
            for (int j = 0; j < B.length;j++){
                int sumAB = A[i] + B[j];
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }

        for (int i = 0;i < C.length;i++){
            for (int j = 0;j < D.length;j++){
                int sumCD = -(C[i] + D[j]);
                res += map.getOrDefault(sumCD, 0);
            }
        }

        return res;
    }
}

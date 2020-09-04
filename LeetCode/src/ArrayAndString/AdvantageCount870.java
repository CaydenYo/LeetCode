package ArrayAndString;

import java.util.TreeMap;

/**
 * @Author cayden
 * @Date 2020/8/29 4:21 下午
 */
public class AdvantageCount870 {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    public int[] advantageCount(int[] A, int[] B){
        for (int i : A){
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[A.length];
        for (int i = 0;i < A.length;i++){
            Integer x = treeMap.higherKey(B[i]);
            if (x == null){
                x = treeMap.firstKey();
            }
            treeMap.put(x, treeMap.get(x) - 1);
            if (treeMap.get(x) == 0){
                treeMap.remove(x);
            }
            res[i] = x;
        }
        return res;
    }
}

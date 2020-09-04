package ArrayAndString;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/8/30 5:27 下午
 */
public class FairCandySwap888 {
    public int[] fairCandySwap(int[] A, int[] B){
        int totalA = 0, totalB = 0;
        for (int a : A){
            totalA += a;
        }
        Set<Integer> setB = new HashSet<>();
        for (int b : B){
            setB.add(b);
            totalB += b;
        }
        int delta = (totalB - totalA) / 2;

        for (int a : A){
            if (setB.contains(a + delta)){
                return new int[]{a, a + delta};
            }
        }
        return new int[]{};
    }
}

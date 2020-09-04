package ArrayAndString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/9/2 11:00 上午
 */
public class HasGroupsSizeX914 {
    /**
     * 先统计所有数字出现的次数
     * 找出所有次数的最小公约数
     * 如果最小公约数小于2，不符合题意返回false
     * */
    public boolean hasGroupsSizeX(int[] deck){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : deck){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.values()){
            res = gcd(i, res);
        }
        return res > 1;
    }

    // 找最小公约数
    private int gcd(int a, int b) {
        if (b > 0){
            return gcd(b, a % b);
        }else {
            return a;
        }
    }
}

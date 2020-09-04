package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/13 3:23 下午
 */
public class HammingDistance461 {
    public int hammingDistance(int x, int y){
        if (x < y){
            return hammingDistance(y, x);
        }
        List<Integer> xlist = new ArrayList<>();
        while (x != 0){
            xlist.add(x % 2);
            x = x >> 1;
        }
        List<Integer> ylist = new ArrayList<>();
        while (y != 0){
            ylist.add(y % 2);
            y = y >> 1;
        }
        while (ylist.size() < xlist.size()){
            ylist.add(0);
        }
        int count = 0;
        for (int i = 0;i < ylist.size();i++){
            if (xlist.get(i) != ylist.get(i)){
                count++;
            }
        }
        return count;
    }

    /**
     * 对x和y做异或操作
     * 如果同一个位置上的数字不一样就会得1，否则为0
     * 然后再数这个异或操作得到的数中1的个数就是汉明距离
     * */
    public int hammingDistance1(int x, int y){
        int z = x ^ y;
        int sum = 0;
        while (z > 0){
            sum += z & 1;
            z = z >> 1;
        }
        return sum;
    }
}

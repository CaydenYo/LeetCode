package Daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/7/7 1:15 下午
 */
public class DivingBoard {
    /**
     * 由于短木板和长木板一共使用k块，有k + 1种组合(考虑其中短木板和长木板的个数各为0的情况)
     * 每种组合下建造的跳水板长度都是不一样的，考虑一下两种组合
     * 1. 有i块长木板，则跳水板长度为shorter * (k - i) + longer * i
     * 2. 有j块长木板，则跳水板长度为shorter * (k - j) + longer * j
     * 上面两式相减得(longer - shorter) * (i - j)
     * 其中0 <= i < j <= k，shorter < longer
     * 所以差值小于0，所以任意两种组合下的跳水板长度都不一样
     * */
    public int[] divingBoard(int shorter, int longer, int k){
        if (k == 0){
            return new int[]{};
        }
        if (shorter == longer){
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        for (int i = 0;i <= k;i++){
            //这样生成的就是升序
            res[i] = i * longer + (k - i) * shorter;
        }
        return res;
    }

}

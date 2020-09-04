package WeekendContest;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/8/22 10:47 下午
 */
public class MaxCoins203 {
    public int maxCoins(int[] piles){
        Arrays.sort(piles);
        int time = piles.length / 3;
        int res = 0;
        int index = piles.length - 2;
        for (int i = 0;i < time;i++){
            res += piles[index];
            index -= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {9,8,7,6,5,1,2,3,4};
        System.out.println(new MaxCoins203().maxCoins(piles));
    }
}

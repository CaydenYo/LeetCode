package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/11 2:38 下午
 */
public class CountBits338 {
    /**
     * 二进制中，所有数字只有两类
     * 1. 奇数：奇数一定比前面一位的偶数多一个1。因为多的就是最低位（偶数最低位一定为0，所以不用担心加1后的进位问题）
     * 2. 偶数：偶数1的个数一定和除以2以后的数一样多，因为最低位是0，除以2就是右移以为，也就是把0消除了，对1的个数没有影响
     * */
    public int[] countBits(int num){
        int[] dp = new int[num + 1];
        for (int i = 1;i <= num;i++){
            if (i % 2 == 0){
                dp[i] = dp[i / 2];
            }else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}

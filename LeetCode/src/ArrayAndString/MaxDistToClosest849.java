package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/29 12:01 上午
 */
public class MaxDistToClosest849 {
    public int maxDistToClosest(int[] seats){
        int prev = -1;
        int max = 1;
        for (int i = 0;i < seats.length;i++){
            // 遇到1时计算有多少个0
            if (seats[i] == 1){
                // prev不等于-1表明前面遇到过1，要除以2
                if (prev >= 0){
                    max = Math.max(max, (i - prev) / 2);
                }else {
                    // 前面没有1不需要除2
                    max = i;
                }
                prev = i;
            }
        }

        // 最后的0个数再判断一次
        max = Math.max(max, (seats.length - 1) - prev);
        return max;
    }
}

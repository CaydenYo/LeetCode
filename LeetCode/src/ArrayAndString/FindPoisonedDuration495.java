package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/23 9:45 下午
 */
public class FindPoisonedDuration495 {
    public int findPoisonedDuration(int[] timeSeries, int duration){
        int res = 0;
        int len = timeSeries.length;
        if (timeSeries == null || len == 0){
            return res;
        }
        for (int i = 1;i < len;i++){
            int interval = timeSeries[i] - timeSeries[i - 1];
            res += interval >= duration ? duration : interval;
        }
        res += duration;

        return res;
    }
}

package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/6/27 5:31 下午
 */
public class Merge56 {
    public int[][] merge(int[][] intervals){
        if (intervals == null || intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < n - 1 && right >= intervals[i + 1][0]){
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{left, right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }

    public int[][] merger1(int[][] intervals){
        if (intervals == null || intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals){
            if (idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;
            }else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }
}

package Sort;

import java.util.Arrays;

public class KClosest973 {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        int[] distance = new int[len];
        for (int i = 0;i < len;i++){
            distance[i] = distance(points[i]);
        }
        Arrays.sort(distance);
        int distK = distance[K - 1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0;i < len;i++){
            if (distance(points[i]) <= distK){
                ans[t++] = points[i];
            }
        }
        return ans;
    }

    private int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}

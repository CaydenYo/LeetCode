package WeekendContest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/1 10:46 下午
 */
public class GetWinner200 {
    public int getWinner(int[] arr, int k){
        int len = arr.length;
        int i = 0, j = 0;
        int count = 0;
        for (;i < len;i++){
            for (j = i + 1;j < len;j++){
                if (arr[i] > arr[j]){
                    count++;
                    if (count == k){
                        return arr[i];
                    }
                    if (j == len - 1){
                        return arr[i];
                    }
                }else {
                    i = j;
                    count = 1;
                }
            }
            if (i == len - 1){
                break;
            }
        }
        return arr[i];
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,6,7};
        System.out.println(new GetWinner200().getWinner(arr, 2));
    }
}

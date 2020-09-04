package WeekendContest;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/7/4 11:47 下午
 */
public class CanMakeArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);
        for (int i = 1;i < arr.length;i++){
            if (arr[i] - arr[i - 1] != 2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1};
        System.out.println(new CanMakeArithmeticProgression().canMakeArithmeticProgression(arr));
    }
}

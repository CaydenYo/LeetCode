package WeekendContest;

/**
 * @Author cayden
 * @Date 2020/8/15 11:59 下午
 */
public class MinOperations202 {
    public int minOperations(int n){
        int res = 0;
        int left = 0, right = n - 1;
        int total = (2 * left + 1 + 2 * right + 1) / 2;
        while (left < right){
            int left_num = 2 * left + 1;
            res += total - left_num;
            left++;
            right--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinOperations202().minOperations(3));
    }
}

package WeekendContest;

/**
 * @Author cayden
 * @Date 2020/8/8 10:54 下午
 */
public class FindKthBit201 {
    public char findKthBit(int n, int k){
        if (n == 1){
            return '0';
        }
        int sum = 0;
        for (int i = 0;i < n;i++){
            sum = sum * 2 + 1;
        }
        int mid = sum / 2 + 1;
        if (k < mid){
            return findKthBit(n - 1, k);
        }else if (k > mid){
            int c = findKthBit(n - 1, mid - (k - mid));
            if (c == '0'){
                return '1';
            }else {
                return '0';
            }
        }else {
            return '1';
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindKthBit201().findKthBit(2, 3));
    }
}

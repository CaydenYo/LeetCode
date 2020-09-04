package BinarySearch;

public class MySqrt69 {
    public int mySqrt(int x) {
        if (x == 1){
            return 1;
        }
        int left = 0;
        int right = x;
        while (right - left > 1){
            int m = left + (right - left) / 2;
            if (x / m < m){
                right = m;
            }else {
                left = m;
            }
        }
        return left;
    }
}

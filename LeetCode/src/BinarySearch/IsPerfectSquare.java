package BinarySearch;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1){
            return true;
        }
        int left = 0;
        int right = num;
        while (right - left > 1){
            int mid = left + (right - left) / 2;
            if (num == mid * mid){
                return true;
            }else if (num / mid < mid){
                right = mid;
            }else {
                left = mid;
            }
        }
        return false;
    }
}

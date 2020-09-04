package BinarySearch;

public class GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0){
                return mid;
            }else if (guess(mid) == -1){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private  int guess(int num){
        return 1;
    }
}

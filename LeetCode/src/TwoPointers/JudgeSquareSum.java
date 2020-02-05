package TwoPointers;

public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int i= 1, j = (int)Math.sqrt(c);
        while (i < j){
            int sum = i * i + j * j;
            if (sum == c){
                return true;
            }else if (sum < c){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}

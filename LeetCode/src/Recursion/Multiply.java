package Recursion;

/**
 * @Author cayden
 * @Date 2020/7/16 5:54 下午
 */
public class Multiply {
    public int multiply(int A, int B){
        if (B == 1){
            return A;
        }
        int halfResult = recursion(0, A, B / 2);
        int rest = B % 2 == 1 ? A : 0;
        return halfResult + halfResult + rest;
    }

    private int recursion(int sum, int num, int count){
        if (count == 0){
            return sum;
        }
        return recursion(sum + num, num, count - 1);
    }

    public int multiply1(int A, int B) {
        if (B == 1) return A;
        return A + multiply1(A, B - 1);
    }

    public static void main(String[] args) {
        new Multiply().multiply(1, 10);
    }
}

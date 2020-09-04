package BinarySearch;

public class MyPow50 {
    /**
     * 已经得到x的n/2次幂的结果，想得到x的n次幂的结果我们可以乘两次前面的结果
     * 如果n为偶数则x的n次幂=x的n/2次幂的平方
     * 如果n为奇数则x的n次幂=x的n/2次幂的平方-1
     * */
    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        if (n == -1){
            return 1 / x;
        }
        if (n == 1){
            return x;
        }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return half * half * rest;
    }

    // 迭代版本，看不懂
    public double myPow1(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    // standard method
    public double fastPow(double x, int n){
        if (n == 0){
            return 1;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0){
            return half * half;
        }else {
            return half * half * x;
        }
    }

    public double myPow2(double x, int n){
        int N = n;
        if (N < 0){
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
}

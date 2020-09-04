package Recursion;

/**
 * @Author cayden
 * @Date 2020/7/20 12:37 下午
 */
public class MyPow50 {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }

    /**
     * n要分奇数和偶数两种情况
     * 如果n为偶数，x的n次方就等于两个x的n / 2次方相乘
     * 如果n为奇数，x的n次方就等于两个x的n / 2次方相乘再乘上一个x
     * 代码中变量n在[−2147483648,2147483647] ，因此当 n = -2147483648时执行 n = -n 会因越界而赋值出错。
     * 解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可
     * */
    public double myPow1(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            // 右移除2
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow50().myPow(2, -2));
    }
}

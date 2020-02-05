package HarshTable;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public IsHappy(int n){
        System.out.println(isHappy(n));
    }

    /*
    private boolean isHappy(int n) {
        int check = 0;
        Set<Integer> hashSet = new HashSet<>();
        while (n != 1){
            while(n != 0){
                check = check + (n % 10) * (n % 10);
                n /= 10;
            }
            n = check;
            check = 0;
            if (n != 1){
                if (!hashSet.contains(n)){
                    hashSet.add(n);
                }else {
                    return false;
                }
            }else {
                return true;
            }
        }
        return true;
    }
     */
    private boolean isHappy(int n){
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(n); // 先把自己加进set中
        while (n != 1){
            n = sumUp(n);
            if (hashSet.contains(n)){
                return false;
            }else {
                hashSet.add(n);
            }
        }
        return true;
    }

    private int sumUp(int n){
        int sum = 0;
        int num = 0;
        while (n != 0){
            num = n % 10;
            n /= 10;
            sum += num * num;
        }
        return sum;
    }

    public static void main(String[] args){
        new IsHappy(19);
    }
}

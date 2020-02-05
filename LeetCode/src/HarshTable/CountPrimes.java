package HarshTable;

public class CountPrimes {
    public CountPrimes(int n){
        System.out.println(countPrimes1(n));
    }

    private int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2;i < n;i++){
            isPrime[i] = true;
        }
        for (int i = 2;i * i < n;i++){
            if (!isPrime[i]){
                continue;
            }
            for (int j = i * i;j < n;j += i){
                isPrime[j] = false;
            }
        }

        int count = 0;
        for (int i = 2;i < n;i++){
            if (isPrime[i]){
                count++;
            }
        }
        return count;
    }

    private int countPrimes1(int n) {
        int count = 0;
        boolean[] isnPrime = new boolean[n];
        for (int i = 2;i * i < n;i++){
            if (!isnPrime[i]){
                for (int j = i * i;j < n;j += i){
                    if (isnPrime[j]){
                        continue;
                    }
                    isnPrime[j] = true;
                    count++;
                }
            }
        }
        return n - count - 2;
    }

    private boolean isPrime(int n){
        if (n <= 1){
            return false;
        }
        for (int i = 2;i * i <= n;i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new CountPrimes(999983));
    }
}

package WeekendContest;

/**
 * @Author cayden
 * @Date 2020/7/19 2:12 下午
 */
public class NumWaterBottles198 {
    public int numWaterBottles(int numBottles, int numExchange){
        int num = numBottles;
        int left = numBottles;
        int count = 0;
        while (num / numExchange != 0){
            num /= numExchange;
            left %= numExchange;
            count += num;
            num += left;
            left = num;
        }

        return numBottles + count;
    }

    public int numWaterBottles1(int numBottles, int numExchange){
        int count = numBottles;
        while (numBottles / numExchange != 0){
            count += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return numBottles + count;
    }

    public static void main(String[] args) {
        new NumWaterBottles198().numWaterBottles1(9,3);
    }
}

package WeekendContest;

/**
 * @Author cayden
 * @Date 2020/8/1 10:39 下午
 */
public class CountGoodTriplets200 {
    public int countGoodTriplets(int[] arr, int a, int b, int c){
        int count = 0;
        int len = arr.length;
        for (int i = 0;i < len;i++){
            for (int j = i + 1;j < len;j++){
                if (Math.abs(arr[i] - arr[j]) <= a){
                    for (int k = j + 1;k < len;k++){
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3,0,1,1,9,7};
        System.out.println(new CountGoodTriplets200().countGoodTriplets(arr, 7, 2, 3));
    }
}

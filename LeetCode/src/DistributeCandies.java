public class DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res= new int[num_people];

        int cnt = 0;

        while(candies > 0){
            res[cnt % num_people] += Math.min(++cnt, candies);
            candies -= cnt;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new DistributeCandies().distributeCandies(7, 4));
    }
}

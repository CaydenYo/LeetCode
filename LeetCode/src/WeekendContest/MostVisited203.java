package WeekendContest;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/8/22 10:30 下午
 */
public class MostVisited203 {
    public List<Integer> mostVisited(int n, int[] rounds){
        Map<Integer, Integer> count_map = new HashMap<>();
        int max = 0;
        for (int i = 0;i < rounds.length - 1;i++){
            int start = rounds[i];
            int end = rounds[i + 1];
            while (start != end){
                count_map.put(start, count_map.getOrDefault(start, 0) + 1);
                max = Math.max(max, count_map.get(start));
                start += 1;
                if (start > n){
                    start = start % n;
                }
            }
        }
        count_map.put(rounds[rounds.length - 1], count_map.getOrDefault(rounds[rounds.length - 1], 0) + 1);
        max = Math.max(max, count_map.get(rounds[rounds.length - 1]));

        List<Integer> res = new ArrayList<>();
        for (int key : count_map.keySet()){
            if (count_map.get(key) == max){
                res.add(key);
            }
        }

        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        return res;
    }

    public static void main(String[] args) {
        int[] rounds = {1,3,5,7};
        for (int i : new MostVisited203().mostVisited(7, rounds)){
            System.out.println(i);
        }
    }
}

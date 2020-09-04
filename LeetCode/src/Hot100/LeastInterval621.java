package Hot100;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/7/14 6:03 下午
 */
public class LeastInterval621 {
    /**
     * 贪心算法：每次先安排出现数量最多的任务，随后在n单位的冷却时间里，安排其他任务
     * 规定n + 1个任务为一轮，这样的好处是同一轮中一个任务最多只能被安排一次
     * 每一轮，我们将当前的任务按照它们剩余的次数降序排序，
     * 并选择剩余次数最多的n + 1个任务依次执行。
     * 注意：如果任务种类t少于n + 1个，就只选择全部的t种任务，其余的时间空闲
     * 这个方法的正确性在于如果次数较多的任务不尽早安排，等次数较少的任务都结束之后，
     * 将会出现一轮中只有一个任务在执行的情况，这会导致大量空闲时间的出现，因此贪心地将次数较多的任务安排在前。
     * */
    public int leastInterval(char[] tasks, int n){
        int[] map = new int[26];
        for (char c : tasks){
            map[c - 'A'] += 1;
        }
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0){
            int i = 0;
            // n + 1个任务为一轮
            while (i <= n){
                // 如果出现次数最多的任务已经做完了
                // 我们需要重新将数组排序，所以break
                if (map[25] == 0){
                    break;
                }
                // 将次数最多的n + 1个任务依次执行
                if (i < 26 && map[25 - i] > 0){
                    map[25 - i]--;
                }
                time++;
                i++;
            }
            // 刷新排序数组
            Arrays.sort(map);
        }
        return time;
    }


    public int leastInterval1(char[] tasks, int n){
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char c : tasks){
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(26, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : hashMap.values()){
            priorityQueue.add(num);
        }
        int time = 0;
        while (!priorityQueue.isEmpty()){
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while (i <= n){
                if (!priorityQueue.isEmpty()){
                    if (priorityQueue.peek() > 1){
                        list.add(priorityQueue.poll() - 1);
                    }else {
                        priorityQueue.poll();
                    }
                }
                time++;
                if (priorityQueue.isEmpty() && list.size() == 0){
                    break;
                }
                i++;
            }
            for (int l :list){
                priorityQueue.add(l);
            }
        }
        return time;
    }

    /**
     * 桶思想
     * 所需时间是(桶个数 - 1) * (冷却时间 + 1) + 最后一桶的任务数
     * 返回以上时间和任务总量之中的最大值
     * */
    public int leastInterval2(char[] tasks, int n){
        int len = tasks.length;
        int[] map = new int[26];
        for (char c : tasks){
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int cnt = 1;
        while (cnt < 26 && map[25 - cnt] == map[25]){
            cnt++;
        }

        return Math.max((map[25] - 1) * (n + 1) + cnt, len);
    }
}

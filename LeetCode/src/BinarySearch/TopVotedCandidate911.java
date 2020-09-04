package BinarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/18 2:51 下午
 */
public class TopVotedCandidate911 {
    int[] times;
    int[] persons;
    int[] maxPersons; // 各时间戳获胜的候选人
    public TopVotedCandidate911(int[] persons, int[] times){
        this.times = times;
        this.persons = persons;
        maxPersons = new int[persons.length];

        // 统计各候选人得票次数
        int[] count = new int[persons.length + 1];
        // 当前获胜者编号
        int curPerson = persons[0];
        // 当前获胜者起码获得一张选票
        int maxCount = 1;
        for (int i = 0;i < persons.length;i++){
            // 类似散列表
            count[persons[i]]++;
            // 当最新出现的候选人的票数大于等于最大值，则当选leader
            if (count[persons[i]] >= maxCount){
                curPerson = persons[i];
                maxCount = count[persons[i]];
            }
            maxPersons[i] = curPerson;
        }
    }

    public int q(int t){
        int low = 0, high = times.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (times[mid] == t){
                low = mid;
                break;
            }else if (times[mid] < t){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        // 如果当前时间还大于t，就减一
        if (t < times[low]){
            low -= 1;
            if (low < 0){
                low = 0;
            }
        }

        return maxPersons[low];
    }
}

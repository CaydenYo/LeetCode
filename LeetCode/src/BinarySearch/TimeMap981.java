package BinarySearch;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/19 8:58 下午
 */
public class TimeMap981 {

    Map<String, List<Pair<Integer, String>>> hashMap;
    public TimeMap981(){
        hashMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        if (!hashMap.containsKey(key)){
            hashMap.put(key, new ArrayList<>());
        }
        hashMap.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp){
        if (!hashMap.containsKey(key)){
            return "";
        }
        List<Pair<Integer, String>> A = hashMap.get(key);
        if (A.get(0).getKey() > timestamp){
            return "";
        }
        int pos = 0;
        int low = 0, high = A.size() - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (A.get(mid).getKey() > timestamp){
                high = mid - 1;
            }else {
                if (mid > pos){
                    pos = mid;
                }
                low = mid + 1;
            }
        }

        return A.get(pos).getValue();
    }
}

package ArrayAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author cayden
 * @Date 2020/8/26 1:08 上午
 */
public class MyCalendar729 {
    TreeMap<Integer, Integer> calendar;
    public MyCalendar729(){
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end){
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start)
                && (next == null || end <= next)){
            calendar.put(start, end);
            return true;
        }
        return false;
    }

    List<int[]> list = new ArrayList<>();

    public boolean book1(int start, int end) {
        int left = 0;
        int right = list.size()-1;
        int pre[] = new int[2];
        while(left<right) {				//二分法，找左侧边界
            int mid = (left+right)/2;
            pre = list.get(mid);
            if(start<=pre[0]) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        pre = list.get(left-1);
        int next[] = list.get(left);
        if(start>=pre[1] && end<=next[0]) {		//判断是否重叠
            list.add(left,new int[] {start,end});
            return true;
        }
        return false;
    }
}

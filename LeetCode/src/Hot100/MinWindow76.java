package Hot100;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/6/28 5:11 下午
 */
public class MinWindow76 {
    /*public String minWindow(String s, String t){
        String res = "";
        int min = Integer.MAX_VALUE;
        Set<Character> set = new HashSet<>();
        char[] tArray = t.toCharArray();
        for (int i = 0;i < tArray.length;i++){
            set.add(tArray[i]);
        }
        Arrays.sort(tArray);
        t = String.valueOf(tArray);

        int left = 0;
        int right = left + t.length();
        while (left < s.length() && right <= s.length()){
            String tmpRes = s.substring(left, right);
            char[] sArray = tmpRes.toCharArray();
            Arrays.sort(sArray);
            String tmp = String.valueOf(sArray);
            if (tmp.contains(t) && tmp.length() < min){
                res = tmpRes;
                min = tmp.length();
                int newstart = 0;
                for (int i = 0;i < tmpRes.length();i++){
                    if (set.contains(tmpRes.charAt(i))){
                        newstart = i;
                        break;
                    }
                }
                for (int i = newstart + 1;i < tmpRes.length();i++){
                    if (set.contains(tmpRes.charAt(i))){
                        left = left + i;
                        break;
                    }
                }
            }else {
                right += 1;
            }
        }


        return res;
    }*/

    public String minWindow(String s, String t){
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0;i < t.length();i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;
        while(right < s.length()){
            // c是将要移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据更新
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                // Integer不能用==比较，要用compareTo
                if (window.get(c).compareTo(need.get(c)) == 0){
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()){
                // 在这里更新最小子串
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                // 更新完后就左移窗口
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据更新
                if (need.containsKey(d)){
                    window.put(d, window.getOrDefault(d, 0) - 1);
                    if (window.get(d) < need.get(d)){
                        valid--;
                    }
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        new MinWindow76().minWindow("aa", "aa");
    }
}

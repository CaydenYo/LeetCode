package Hot100;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/7/13 11:11 上午
 */
public class FindAnagrams438 {
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null){
            return res;
        }
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        p = String.valueOf(pArray);
        for (int i = 0;i <= s.length() - p.length();i++){
            String tmp = s.substring(i, i + p.length());
            char[] tmpArray = tmp.toCharArray();
            Arrays.sort(tmpArray);
            tmp = String.valueOf(tmpArray);
            if (tmp.equals(p)){
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 滑动窗口
     * */
    public List<Integer> findAnagrams1(String s, String p){
        List<Integer> res = new ArrayList<>();
        if (s == null || s.equals("") || s.length() < p.length()){
            return res;
        }
        // 记录目标值中各个单词出现的次数
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0;i < p.length();i++){
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        // 记录滑动窗口内有效字符出现的次数
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()){
            // c1是要移入窗口的字符
            char c1 = s.charAt(right);
            // 窗口右移
            right++;
            // 只有当前字符存在于目标子串中才存入window
            if (need.containsKey(c1)){
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                // 如果window中该有效字符数量等于该字符数量才能算一次有效包含
                if (window.get(c1).compareTo(need.get(c1)) == 0){
                    valid++;
                }
            }
            // 当window符合要求，即两个map存储的有效字符相同，就可以左移指针
            while (valid == need.size()){
                // 当window的大小等于目标子串的大小才可记录起始索引
                if (right - left == p.length()){
                    res.add(left);
                }
                // 记录左指针指向的字符
                char c2 = s.charAt(left);
                // 窗口左移
                left++;
                // 如果此字符是有效字符，则需要把window内对应的value减1
                if (need.containsKey(c2)){
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                    // 如果减完之后有效字符对应的数量比目标子串少，说明无法匹配，valid减1
                    if (window.get(c2) < need.get(c2)){
                        valid--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        new FindAnagrams438().findAnagrams1(s, p);
    }
}

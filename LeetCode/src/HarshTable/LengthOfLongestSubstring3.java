package HarshTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring3 {
    public LengthOfLongestSubstring3(String s) {
        System.out.println(lengthOfLongestSubstring2(s));
    }

    // 使用HarshSet逐个逐个移动窗口
    private int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        Set<Character> hashSet = new HashSet<>();
        int res = 0, i = 0, j = 0;
        while (i < len && j < len){
            // 移动窗口
            if (!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j));
                j++;
                res = Math.max(res, j - i);
            }else {
                hashSet.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }

    // 使用hashMap一次性滑动窗口
    private int lengthOfLongestSubstring2(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args){
        new LengthOfLongestSubstring3("abcabcbb");
    }
}

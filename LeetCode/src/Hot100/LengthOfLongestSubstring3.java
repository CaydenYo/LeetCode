package Hot100;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> hashMap = new HashMap<>();
        int max = 0, i = 0, j = 0;
        while (j < n){
            if (hashMap.containsKey(s.charAt(j))){
                i = Math.max(i, hashMap.get(s.charAt(j)));
            }
            max = Math.max(max, j - i + 1);
            hashMap.put(s.charAt(j), j + 1);
            j++;
        }
        return max;
    }
}

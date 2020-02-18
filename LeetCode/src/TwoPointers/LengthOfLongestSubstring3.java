package TwoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring3 {
    public LengthOfLongestSubstring3(String s){
        System.out.println(lengthOfLongestSubstring1(s));
    }

    private int lengthOfLongestSubstring1(String s) {
        int k = 0;
        int i, j, max = 0;
        for (i = 0;i < s.length();i++){
            for (j = k;j < i;j++){
                if (s.charAt(j) == s.charAt(i)){
                    k = j + 1;
                    break;
                }
            }
            if(i - k + 1 > max){
                max = i - k + 1;
            }
        }
        return max;
    }

    private int lengthOfLongestSubstring2(String s){
        int n = s.length();
        Set<Character> hashSet = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n){
            if (!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else {
                hashSet.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    private int lengthOfLongestSubstring3(String s){
        int n = s.length();
        Map<Character, Integer> hashMap = new HashMap<>();
        int ans = 0, i = 0, j = 0;
        while (j < n){
            if (hashMap.containsKey(s.charAt(j))){
                i = Math.max(i, hashMap.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i + 1);
            hashMap.put(s.charAt(j), j + 1);
            j++;
        }
        return ans;
    }

    public static void main(String[] args){
        new LengthOfLongestSubstring3(" ");
    }

}

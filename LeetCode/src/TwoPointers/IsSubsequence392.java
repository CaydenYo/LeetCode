package TwoPointers;

/**
 * @Author cayden
 * @Date 2020/8/16 6:35 下午
 */
public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t){
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else {
                j++;
            }
        }
        return i == s.length();
    }
}

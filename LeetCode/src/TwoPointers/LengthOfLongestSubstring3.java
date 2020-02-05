package TwoPointers;

public class LengthOfLongestSubstring3 {
    public LengthOfLongestSubstring3(String s){
        System.out.println(lengthOfLongestSubstring(s));
    }

    private int lengthOfLongestSubstring(String s) {
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

    public static void main(String[] args){
        new LengthOfLongestSubstring3(" ");
    }

}

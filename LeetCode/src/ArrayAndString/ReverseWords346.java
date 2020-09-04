package ArrayAndString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords346 {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(str);

        int n = sb.length();
        int start = 0;
        int end = 0;
        while (start < n){
            while (end < n && sb.charAt(end) != ' '){
                end += 1;
            }
            reverseEachWord(sb, start, end - 1);
            // update start and end
            start = end + 1;
            end += 1;
        }

        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb, int start, int end){
        while (start < end){
            char tmp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, tmp);
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new ReverseWords346().reverseWords(s));
    }
}

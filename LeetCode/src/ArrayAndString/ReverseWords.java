package ArrayAndString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public String reverseWords(String s) {
        s = cleanBlanks(s);
        String[] arr = s.split(" ");
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < arr.length;i++){
            stringBuilder.append(arr[i]);
            stringBuilder.append(" ");
        }
        s = stringBuilder.toString().substring(0, s.length());
        return s;
    }

    // clean blanks
    private String cleanBlanks(String s){
        s = s.trim();
        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0;i < s.length();i++){
//            if (s.charAt(i) != ' '){
//                stringBuilder.append(s.charAt(i));
//            }else {
//                stringBuilder.append(s.charAt(i));
//                for (int j = i + 1;j < s.length();j++){
//                    if (s.charAt(j) != ' '){
//                        i = j - 1;
//                        break;
//                    }
//                }
//            }
//        }
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            char c = s.charAt(left);
            if (c != ' '){
                stringBuilder.append(c);
            }else if (stringBuilder.charAt(stringBuilder.length() - 1) != ' '){
                stringBuilder.append(c);
            }
            left++;
        }
        return stringBuilder.toString();
    }

    // faster
    private void reverse(StringBuilder sb, int left, int right){
        while (left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    private void reverseEachWord(StringBuilder sb){
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n){
            while (end < n && sb.charAt(end) != ' '){
                end += 1;
            }
            // reverse word
            reverse(sb, start, end - 1);
            // update start
            start = end + 1;
            end += 1;
        }
    }

    /**
     * use api
     * */
    public String reverseWords1(String s){
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords(" a good   example "));
    }
}

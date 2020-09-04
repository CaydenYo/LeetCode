package BackTracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
    String[] dialLetters = {"abc", "def", "ghi", "jkl", "mno","pqrs", "tuv","wxyz"};
    int len;
    List<String> res = new LinkedList<>();
    String digits;
    public List<String> letterCombinations(String digits) {
        if (digits.equals("") || digits == null){
            return res;
        }
        len = digits.length();
        this.digits = digits;
        backtrack("", 0);
        return res;
    }

    public void backtrack(String curStr, int index){
        if (curStr.length() == len){
            res.add(curStr);
            return;
        }
        for (int i = index;i < len;i++){
            String dialLetter = dialLetters[digits.charAt(i) - '0' - 2];
            for (int j = 0;j < dialLetter.length();j++){
                backtrack(curStr + dialLetter.charAt(j), i + 1);
            }
        }
    }

    // 能用substring
    // substring会比charAt更快
    // 有可能是因为charAt调用了循环，因此导致时间复杂度变高了
    public void backtrack(String curStr, String next_digits){
        if (next_digits.length() == 0){
            res.add(curStr);
        }else {
            char digit = next_digits.charAt(0);
            String letter = dialLetters[digit - '0' - 2];
            for (int i = 0;i < letter.length();i++){
                backtrack(curStr + letter.charAt(i), next_digits.substring(1));
            }
        }
    }

    public static void main(String[] args){
        String str = "23";
        System.out.println(new LetterCombinations().letterCombinations(str));
    }

}

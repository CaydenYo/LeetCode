package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/6/19 10:39 下午
 * @Description:
 *      能用substring
 *      substring会比charAt更快
 *      有可能是因为charAt调用了循环，因此导致时间复杂度变高了
 */
public class LetterCombinations17 {
    String[] dialLetters = {"abd", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    int len;
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits){
        if (digits == null || digits.equals("")){
            return res;
        }
        len = digits.length();
        backtrack("", digits, 0);
        return res;
    }

    private void backtrack(String str, String digits, int index){
        if (str.length() == len){
            res.add(str);
            return;
        }
        for (int i = index;i < len;i++){
            String dialLetter = dialLetters[digits.charAt(index) - '0' - 2];
            for (int j = 0;j < dialLetter.length();j++){
                backtrack(str + dialLetter.charAt(j), digits, i + 1);
            }
        }

    }
}

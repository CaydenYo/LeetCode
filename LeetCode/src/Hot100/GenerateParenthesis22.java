package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/6/21 5:37 下午
 */
public class GenerateParenthesis22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n){
        if (n < 1){
            return res;
        }
        backtrack("", n, n, res);
        return res;
    }

    private void backtrack(String curStr, int left, int right, List<String> res){
        if (left > right){
            return;
        }
        if (right == 0){
            res.add(curStr);
        }
        if (left > 0){
            backtrack(curStr + '(', left - 1, right, res);
        }
        if (right > 0){
            backtrack(curStr + ')', left, right - 1, res);
        }
    }
}


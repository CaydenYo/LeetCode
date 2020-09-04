package ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/27 8:52 下午
 */
public class LargeGroupPositions830 {
    public List<List<Integer>> largeGroupPositions(String S){
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.equals("")){
            return res;
        }
        for (int i = 0, j = 0;i < S.length();i = j){
            while (j < S.length() && S.charAt(j) == S.charAt(i)){
                j++;
            }
            if (j - i >= 3){
                res.add(Arrays.asList(i, j - 1));
            }
        }
        return res;
    }
}

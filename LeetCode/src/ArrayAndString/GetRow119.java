package ArrayAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/20 10:51 下午
 */
public class GetRow119 {
    public List<Integer> getRow(int rowIndex){
        return generate(rowIndex + 1).get(rowIndex);
    }

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0){
            return res;
        }
        if (numRows == 1){
            res.add(new ArrayList<>());
            res.get(0).add(1);
            return res;
        }
        res = generate(numRows - 1);
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1;i < numRows - 1;i++){
            row.add(res.get(numRows - 2).get(i - 1) + res.get(numRows - 2).get(i));
        }
        row.add(1);
        res.add(row);
        return res;
    }
}

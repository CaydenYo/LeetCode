package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/23 11:01 下午
 */
public class MatrixReshape566 {
    public int[][] matrixReshape(int[][] nums, int r, int c){
        int or = nums.length;
        int oc = nums[0].length;
        if (or * oc < r * c || (or == r && oc == c)){
            return nums;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < or;i++){
            for (int j = 0;j < oc;j++){
                list.add(nums[i][j]);
            }
        }
        int index = 0;
        int[][] res = new int[r][c];
        for (int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                res[i][j] = list.get(index++);
            }
        }

        return res;
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c){
        int or = nums.length;
        int oc = nums[0].length;
        if (or * oc < r * c || (or == r && oc == c)){
            return nums;
        }
        int[][] res = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0;i < or;i++){
            for (int j = 0;j < oc;j++){
                res[row][col] = nums[i][j];
                col++;
                if (col == c){
                    row++;
                    col = 0;
                }
            }
        }
        return res;
    }
}

package Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cayden
 * @Date 2020/6/29 8:39 下午
 */
public class MaximalRectangle85 {
    /**
     * 暴力解法：
     * 遍历每个点，求以这个点为矩阵右下角的所有面积(之所以以这个点为右下角是因为遍历顺序从左到右，从上到下)
     * 为了找出这样的矩阵，我们需要知道以这个点结尾的连续1的个数
     * 首先求出高度是1的矩形面积，也就是自身的的数
     * 然后向上扩展一行，高度增加1，选出最小的数字的那一列，作为矩阵的宽，求出面积
     * 然后继续扩展重复以上步骤，直至遍历所有点
     * */
    public int maximalRectangle(char[][] matrix){
        if (matrix.length == 0){
            return 0;
        }
        // 保存以当前数字结尾的连续1的个数
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        // 遍历每一行
        for (int row = 0;row < matrix.length;row++){
            for (int col = 0;col < matrix[0].length;col++){
                // 更新width
                if (matrix[row][col] == '1'){
                    if (col == 0){
                        width[row][col] = 1;
                    }else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                }else {
                    width[row][col] = 0;
                }
                // 记录所有行中最小的数
                int minWidth = width[row][col];
                // 向上扩展行
                for (int up_row = row;up_row >= 0;up_row--){
                    int height = row - up_row + 1;
                    // 找最小的数作为矩阵的宽
                    minWidth = Math.min(minWidth, width[up_row][col]);
                    // 更新面积
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }

        return maxArea;
    }

    /**
     * 这题可以转化为第84题，求柱状图中的最大矩形
     * 只要逐层扫描，每扫描一层就把当前的高度数组传入之前的栈方法中
     * 然后更新面积
     * */
    public int maximalRectangleStack(char[][] matrix){
        if (matrix.length == 0){
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0;row < matrix.length;row++){
            for (int col = 0;col < matrix[0].length;col++){
                if (matrix[row][col] == '1'){
                    heights[col] += 1;
                }else {
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleAreaStack(heights));
        }

        return maxArea;
    }

    private int largestRectangleAreaStack(int[] heights){
        int len = heights.length;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return heights[0];
        }

        // 前后各加一个哨兵
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 先放哨兵避免一开头就判空
        stack.addLast(0);
        for (int i = 1;i < len;i++){
            while (heights[i] < heights[stack.peekLast()]){
                int height = heights[stack.pollLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, height * width);
            }
            stack.addLast(i);
        }
        return area;
    }
}

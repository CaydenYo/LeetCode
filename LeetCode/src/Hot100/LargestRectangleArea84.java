package Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cayden
 * @Date 2020/6/29 5:50 下午
 */
public class LargestRectangleArea84 {
    /**
     * 暴力解法：
     * 遍历每根柱子，以当前柱子i的高度作为矩形的高，
     * 那么矩形的宽度边界即为向左找第一个高度小于当前柱体i的柱体，向右找到第一个高度小于当前柱体i的柱体
     * */
    public int largestRectangleArea(int[] heights){
        int area = 0, n = heights.length;
        for (int i = 0;i < n;i++){
            int width = 1, height = heights[i],j = i;
            while (--j >= 0 && heights[j] >= height){
                width++;
            }
            j = i;
            while (++j < n && heights[j] >= height){
                width++;
            }
            area = Math.max(area, width * height);
        }
        return area;
    }

    /**
     * 单调增栈：
     * 栈内元素保持单调递增，
     * 如果遇到新元素小于栈顶元素，则栈顶元素出栈，
     * 新元素是出栈元素向后找的第一个比其小的元素
     * 因为是栈内递增，所以出栈后的新栈顶元素是栈顶元素向前找的第一个比起小的元素
     * */
    public int largestRectangleAreaStack(int[] heights){
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

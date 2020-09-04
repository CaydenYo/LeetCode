package Hot100;

import java.util.Stack;

/**
 * @Author cayden
 * @Date 2020/6/25 12:11 下午
 */
public class Trap42 {
    /**
     * 求第i层的水，遍历每个位置，如果当前的高度小于i，并且两边有高度大于i的就说明这地方有水
     * 如果求高度为i的水，首先用一个变量temp保存当前积累的水，初始化为0
     * 从左到右遍历墙的高度，遇到高度大于i的时候开始更新temp。
     * 更新原则是遇到高度小于i的就把temp加1，遇到高度大于等于i的，就把temp加到最终的答案ans里，并且temp置零
     * */
    public int trapRow(int[] height){
        int sum = 0;
        int max = getMax(height);
        for (int i = 1;i <= max;i++){
            boolean isStart = false;
            int temp_sum = 0;
            for (int j = 0;j < height.length;j++){
                if (isStart && height[j] < i){
                    temp_sum++;
                }
                if (height[i] >= i){
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }

        return sum;
    }

    private int getMax(int[] height){
        int max = 0;
        for (int i = 0;i < height.length;i++){
            max = Math.max(max, height[i]);
        }
        return max;
    }

    /**
     * 求每一列的水，我们只需要关注当前列，以及左边最高的墙，右边最高的墙就够了，有三种情况
     * 较矮的墙的高度大于当前列的墙的高度
     * 较矮的墙的高度小于当前列的墙的高度
     * 较矮的墙的高度等于当前列的墙的高度
     * */
    public int trapCol(int[] height){
        int sum = 0;
        // 最两端的列不用考虑，因为一定不会有水，所以下标从1到length - 2
        for(int i = 1;i <= height.length - 2;i++){
            int max_left = 0;
            // 找出左边最高
            for (int j = i - 1;j >= 0;j--){
                if (height[j] > max_left){
                    max_left = height[j];
                }
            }
            int max_right = 0;
            // 找出右边最高
            for (int j = i + 1;j < height.length;j++){
                if (height[j] > max_right){
                    max_right = height[j];
                }
            }
            // 找出两端较小的
            int min = Math.min(max_left, max_right);
            if (min > height[i]){
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public int trapDP(int[] height){
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1;i < height.length - 1;i++){
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2;i >= 0;i--){
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1;i < height.length - 1;i++){
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]){
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public int trapTwoPointers(int[] height){
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 1. 当前高度小于等于栈顶高度，入栈，指针后移
     * 2. 当前高度大于栈顶高度，出栈，计算当前墙与新栈顶的墙之间水的多少，然后计算当前的高度和新栈顶的高度的关系，重复第二步，
     *    直到当前墙的高度不大于栈顶高度或者占空，然后把当前墙入栈，指针后移。
     * */
    public int trapStack(int[] height){
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length){
            // 如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[current] > height[stack.peek()]){
                int h = height[stack.pop()];
                if (stack.isEmpty()){
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}

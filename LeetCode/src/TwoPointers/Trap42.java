package TwoPointers;

import java.util.Stack;

public class Trap42 {
    // trap by column
    public int trapByColumn(int[] height) {
        int sum = 0;
        // there is no water in the i = 0 and i = height.length - 1 column
        for (int i = 1; i < height.length - 1;i++){
            int left_max = 0;
            for (int j = i - 1;j >= 0;j--){
                left_max = Math.max(left_max, height[j]);
            }

            int right_max = 0;
            for (int j = i + 1;j <= height.length - 1;j++){
                right_max = Math.max(right_max, height[j]);
            }

            int minMax = Math.min(left_max, right_max);
            sum += (minMax > height[i]) ? minMax - height[i] : 0;
        }

        return sum;
    }

    // trap by dynamic programming
    public int trapByDP(int[] height) {
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
            int minMax = Math.min(max_left[i], max_right[i]);
            sum += (minMax > height[i]) ? minMax - height[i] : 0;
        }
        return sum;
    }

    // trap by one pointer and one array
    public int trayByOnePointer(int[] height){
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];
        for (int i = height.length - 2; i >= 0;i--){
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1;i < height.length - 1;i++){
            max_left = Math.max(max_left, height[i - 1]);
            int minMax = Math.min(max_left, max_right[i]);
            sum += (minMax > height[i]) ? minMax - height[i] : 0;
        }

        return sum;
    }

    // trap by two pointers
    public int trapByTwoPointers(int[] height){
        int sum = 0;
        int max_left = 0, max_right = 0;
        int left = 1, right = height.length - 2;
        for (int i = 1;i < height.length - 1;i++){
            if (height[left - 1] < height[right + 1]){
                max_left = Math.max(max_left, height[left - 1]);
                int minMax = max_left;
                sum += (minMax > height[left]) ? minMax - height[left] : 0;
                left++;
            }else {
                max_right = Math.max(max_right, height[right + 1]);
                int minMax = max_right;
                sum += (minMax > height[right]) ? minMax - height[right] : 0;
                right--;
            }
        }
        return sum;
    }

    // trap by stack
    public int trayByStack(int[] height){
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < height.length;i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int h = height[stack.pop()];
                if (stack.isEmpty()){
                    break;
                }
                // distance between two walls
                int  distance = i - stack.peek() - 1;
                int min = Math.min(height[i], height[stack.peek()]);
                sum += distance * (min - h);
            }
            stack.push(i);
        }
        return sum;
    }
}

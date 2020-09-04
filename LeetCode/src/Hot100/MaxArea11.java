package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/19 12:22 下午
 */
public class MaxArea11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right){
            if (height[left] <= height[right]){
                max = Math.max(max, (right - left) * height[left]);
                left++;
            }else {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        new MaxArea11().maxArea(height);
    }
}

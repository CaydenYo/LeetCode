package TwoPointers;

public class MaxArea11 {
    public MaxArea11(int[] height){
        System.out.println(maxArea(height));
    }

    private int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;// 数组开头
        int j = height.length - 1; // 数组结尾
        while (i < j){
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]){
                i += 1;
            }else {
                j -= 1;
            }
        }

        return maxArea;
    }

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        new MaxArea11(height);
    }
}

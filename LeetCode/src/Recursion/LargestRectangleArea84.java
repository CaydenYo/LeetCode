package Recursion;

public class LargestRectangleArea84 {
    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    // divide and conquer
    // find the min value in each part and then calculate area
    private int calculateArea(int[] heights, int start, int end) {
        if (start > end){
            return 0;
        }
        int minIndex = start;
        for (int i = start;i <= end;i++){
            if (heights[minIndex] > heights[i]){
                minIndex = i;
            }
        }
        return Math.max(heights[minIndex] * (end - start + 1), Math.max(calculateArea(heights, start, minIndex - 1), calculateArea(heights, minIndex + 1, end)));
    }
}

package BinarySearch;

/**
 * @Author cayden
 * @Date 2020/8/15 8:03 下午
 */
public class TwoSum167 {
    public int[] twoSum(int[] numbers, int target){
        int low = 0, high = numbers.length - 1;
        while (low < high){
            if (numbers[low] + numbers[high] == target){
                return new int[]{low + 1, high + 1};
            }else if (numbers[low] + numbers[high] < target){
                low++;
            }else {
                high--;
            }
        }
        return new int[]{};
    }
}

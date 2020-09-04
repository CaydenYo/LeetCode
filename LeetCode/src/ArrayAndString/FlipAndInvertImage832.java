package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/27 10:16 下午
 */
public class FlipAndInvertImage832 {
    public int[][] flipAndInvertImage(int[][] A){
        for (int[] a : A){
            int left = 0, right = a.length - 1;
            while (left < right){
                a[left] = a[left] == 1 ? 0 : 1;
                a[right] = a[right] == 1? 0 : 1;
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
                left++;
                right--;
            }
            if (left == right){
                a[left] = a[left] == 1 ? 0 : 1;
            }
        }
        return A;
    }
}

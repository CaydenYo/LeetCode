package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/30 5:52 下午
 */
public class IsMonotonic896 {
    public boolean isMonotonic(int[] A){
        int len = A.length;
        if (len == 1){
            return true;
        }
        int i = 0, j = 1;
        while (A[i] == A[j]){
            i += 1;
            j += 1;
            if (j == len){
                return true;
            }
        }
        if (A[j] - A[i] > 0){
            for (int k = j + 1;k < len;k++){
                if (A[k] - A[k - 1] < 0){
                    return false;
                }
            }
        }else {
            for (int k = j + 1;k < len;k++){
                if (A[k] - A[k - 1] > 0){
                    return false;
                }
            }
        }
        return true;
    }
}

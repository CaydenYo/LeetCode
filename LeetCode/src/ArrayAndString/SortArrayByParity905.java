package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/30 6:24 下午
 */
public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] A){
        if (A.length == 1){
            return A;
        }
        int last = -1;
        for (int i = 0;i < A.length;i++){
            if (A[i] % 2 == 1){
                for (int j = last == -1 ? i + 1 : last;j < A.length;j++){
                    if (A[j] % 2 == 0){
                        last = j;
                        break;
                    }
                }
                if(last >= 0){
                    int tmp = A[i];
                    A[i] = A[last];
                    A[last] = tmp;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1,0,2};
        new SortArrayByParity905().sortArrayByParity(A);
    }
}

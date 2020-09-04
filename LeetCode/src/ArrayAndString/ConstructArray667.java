package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/24 9:12 下午
 */
public class ConstructArray667 {
    public int[] constructArray(int n, int k){
        int[] res = new int[n];
        for (int i = 0;i < n;i++){
            res[i] = i + 1;
        }
        if (k == 1){
            return res;
        }
        // k不等于1就要翻转k - 1次
        for (int i = 1;i < k;i++){
            reverse(res, i, n - 1);
        }

        return res;
    }

    private void reverse(int[] res, int i, int j) {
        while (i < j){
            int tmp = res[i];
            res[i] = res[j];
            res[j] = tmp;
            i++;
            j--;
        }
    }
}

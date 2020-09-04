package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/7 5:24 下午
 */
public class ProductExceptSelf238 {
    public int[] productExceptSelf(int[] nums){
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0;i < nums.length;i++){
            res[i] = k;
            k *= nums[i];// 此时数组存储的是除去当前元素左边的元素乘积
        }
        k = 1;
        for (int i = nums.length- 1;i >= 0;i--){
            res[i] *= k;// 此时数组等于左边的乘该数右边的
            k *= nums[i];// k为该数右边的乘积
        }

        return res;
    }
}

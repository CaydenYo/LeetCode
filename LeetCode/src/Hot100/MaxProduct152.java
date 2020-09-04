package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/2 8:50 下午
 */
public class MaxProduct152 {
    /**
     * 遍历数组计算当前最大值，不断更新
     * 令imax为当前最大值，则当前最大值为imax = max(imax * nums[i], nums[i)
     * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i)
     * 当负数出现时则imax与imin进行交换再进行下一步计算
     *
     * 考虑当前位置如果是一个负数的话，
     * 那么我们希望以它前一个位置结尾的某个段的积也是个负数，
     * 这样就可以负负得正，并且我们希望这个积尽可能「负得更多」，即尽可能小。
     *
     * 如果当前位置是一个正数的话，
     * 我们更希望以它前一个位置结尾的某个段的积也是个正数，
     * 并且希望它尽可能地大
     * 于是这里我们可以再维护一个 min(i)，它表示以第 i 个元素结尾的乘积最小子数组的乘积
     * */
    public int maxProduct(int[] nums){
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }


}

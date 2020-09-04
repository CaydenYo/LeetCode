package ArrayAndString;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/8/24 12:39 上午
 */
public class TriangleNumber611 {
    /**
     * 对数组排序，固定最长的一条边nums[i]，运用双指针扫描
     * 如果nums[l] + nums[r] > nums[i]，
     * 则说明l到r - 1之间的所有边都可以和r，i组成三角形(r - l种组合)，r左移进入下一轮
     * 如果nums[l] + nums[r] <= nums[i],
     * 则不符合条件，证明r不够大，将r右移进入下一轮
     * */
    public int triangleNumber(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1;i >= 2;i--){
            int l = 0, r = i - 1;
            while (l < r){
                if (nums[l] + nums[r] > nums[i]){
                    res += r - l;
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
}

package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/21 8:55 下午
 */
public class MajorityElement229 {
    /**
     * 因为要选出数量大于n/3的元素
     * 则表示至多只能选出两个元素
     * 因此用改进的摩尔投票法选两个候选人
     * */
    public List<Integer> majorityElement(int[] nums){
        // 创建返回值
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        // 初始化两个候选人和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
        // 配对阶段
        for (int num : nums){
            // 投票
            if (cand1 == num){
                count1++;
                continue;
            }
            if (cand2 == num){
                count2++;
                continue;
            }
            // 第一个候选人配对
            if (count1 == 0){
                cand1 = num;
                count1 = 1;
                continue;
            }
            if (count2 == 0){
                cand2 = num;
                count2 = 1;
                continue;
            }
            count1--;
            count2--;
        }

        // 计数阶段
        // 找到两个候选人之后，需要确定票数是否满足大于n / 3
        count1 = 0;
        count2 = 0;
        for (int num : nums){
            if (cand1 == num){
                count1++;
            }else if (cand2 == num){
                count2++;
            }
        }

        if (count1 > nums.length / 3){
            res.add(cand1);
        }
        if (count2 > nums.length / 3){
            res.add(cand2);
        }

        return res;
    }
}

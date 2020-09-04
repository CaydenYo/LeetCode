package Daily;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/7/13 9:28 上午
 */
public class Intersect350 {
    /**
     * 把长度较短的数组放入哈希表中
     * 再一个个元素遍历长度较长的数组
     * 如果当前元素存在于哈希表中就放入结果集
     * 并且把哈希表中的相应元素的个数减一
     * */
    public int[] intersect(int[] nums1, int[] nums2){
        if (nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums1){
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        int idx = 0;
        for (int num : nums2){
            int count = hashMap.getOrDefault(num, 0);
            if (count > 0){
                nums1[idx++] = num;
                hashMap.put(num, hashMap.get(num) - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, idx);
    }

    /**
     * 双指针
     * 将两个数组分别排序
     * 下标分别是i和j
     * 如果nums1[i] > nums2[j]，为了让它们尽可能靠近，要把j + 1
     * 如果nums1[i] < nums2[j]，同理，把i + 1
     * 如果相等的话，就把当前元素加入结果集，同时i++，j++
     * */
    public int[] intersect1(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0;i < nums1.length && j < nums2.length;){
            if (nums1[i] > nums2[j]){
                j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}

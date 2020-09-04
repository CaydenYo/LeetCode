package BinarySearchTree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate220 {
    /**
     * 初始化一颗空的二叉搜索树set
     * 对于每一个元素x，遍历整个 数组
     * 在set上查找大于等于x的最小的数也就是right min，如果s - x <= t则返回true
     * 在set上查找小于等于x的最大的数也就是left max，如果x - g <= t则返回true
     * 在set中插入x
     * 如果树的大小超过了k，则移除最早加入树的那个数
     * */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0;i < nums.length;i++){
            // find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t){
                return true;
            }

            // find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t){
                return true;
            }

            set.add(nums[i]);
            if (set.size() > k){
                set.remove(nums[i - k]);
            }
        }

        return false;
    }


    /**
     * 我们不妨把把每个元素当做一个人的生日来考虑一下。假设你是班上新来的一位学生，你的生日在三月的某一天，
     * 你想知道班上是否有人生日跟你生日在 t=30t=30 天以内。在这里我们先假设每个月都是30天，
     * 很明显，我们只需要检查所有生日在 二月，三月，四月 的同学就可以了。
     *
     * 之所以能这么做的原因在于，我们知道每个人的生日都属于一个桶，我们把这个桶称作月份,
     * 每个桶所包含的区间范围都是t，这能极大的简化我们的问题。
     * 很显然，任何不在同一个桶或相邻桶的两个元素之间的距离一定是大于t的。
     *
     * 我们把上面提到的桶的思想应用到这个问题里面来，
     * 我们设计一些桶，让他们分别包含区间 ..., [0,t], [t+1, 2t+1], ......,[0,t],[t+1,2t+1],...。
     * 我们把桶来当做窗口，于是每次我们只需要检查x所属的那个桶和相邻桶中的元素就可以了。
     *
     * 这个问题和桶排序的不同之处在于每次我们的桶里只需要包含最多一个元素就可以了，
     * 因为如果任意一个桶中包含了两个元素，那么这也就是意味着这两个元素是 足够接近的 了，
     * 这时候我们就直接得到答案了。因此，我们只需使用一个标签为桶序号的散列表就可以了。
     * */

    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the neighbor buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in nei***or buckets
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }
}

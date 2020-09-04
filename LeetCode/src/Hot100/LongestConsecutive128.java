package Hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/7/1 8:17 下午
 */
public class LongestConsecutive128 {

    /**
     * 将数组的元素放入set中，利用set的数据结构特性去重，且set的寻找元素时间是O(1)
     * 这里看似有两重循环，但实际上每个元素只被遍历了一次
     * 原因在于，我们在第二重循环总是从最小遍历到最大，中间的元素已经被遍历过了
     * 因此如果在外层循环碰到中间元素时我们就跳过，即我们每次在外层遍历的时候寻找的是没有前驱元素的元素。
     * */
    public int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int max = 0;
        for (int num : nums){
            if (!set.contains(num - 1)){
                int currentNum = num;
                int currentDis = 1;
                while (set.contains(currentNum + 1)){
                    currentDis++;
                    currentNum++;
                }
                max = Math.max(max, currentDis);
            }
        }
        return max;
    }

    /**
     * 并查集
     * */
    Map<Integer,Integer> findMap=new HashMap<>();
    Map<Integer,Integer> sizeMap=new HashMap<>();
    int max=1;
    public int longestConsecutive1(int[] nums) {
        //方法2：并查集
        if (nums.length<1)
            return 0;
        for (int item:nums) {
            findMap.put(item,item);
            sizeMap.put(item,1);
        }
        for(int item:nums){
            if (findMap.containsKey(item-1)){
                union(item,item-1);
            }
        }
        return max;
    }

    public int find(int son){//带路径优化的查找
        int parent=findMap.get(son);
        if (parent!=son)
            parent = find(parent);
        findMap.put(son,parent);
        return parent;
    }

    public void union(int root1,int root2){
        int father1=find(root1);
        int father2=find(root2);
        if (father1!=father2){
            int size1=sizeMap.get(father1);
            int size2=sizeMap.get(father2);
            //按秩合并，将深度小的合并到深度大的上去
            if (size1>size2){
                findMap.put(father2,father1);
                sizeMap.put(father1,size1+size2);
            }else {
                findMap.put(father1,father2);
                sizeMap.put(father2,size1+size2);
            }
            max=Math.max(max,size1+size2);
        }
    }
}

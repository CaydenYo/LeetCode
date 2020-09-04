package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/3 9:11 下午
 */
public class FindFrequentTreeSum508 {
    Map<Integer, Integer> hashMap = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root){
        if (root == null){
            return new int[0];
        }
        int maxCount = 0;
        List<Integer> list = new ArrayList<>();
        sum(root);
        for (int key : hashMap.keySet()){
            int count = hashMap.get(key);
            if (count > maxCount){
                maxCount = count;
                list.clear();
                list.add(key);
            }else if (count == maxCount){
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private int sum(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        int result = left + right + root.val;
        hashMap.put(result, hashMap.getOrDefault(result, 0) + 1);
        return result;
    }
}

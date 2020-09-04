package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/3 6:16 下午
 */
public class FindMode501 {
    List<Integer> items;
    int maxCount;
    int curCount;
    TreeNode pre = null;
    public int[] findMode(TreeNode root){
        if (root == null){
            return new int[0];
        }
        items = new ArrayList<>();
        maxCount = 1;
        curCount = 1;
        inorder(root);
        // 递归结束时没有处理最右端节点，此处需要手动更新
        if (curCount >  maxCount){
            return new int[] {pre.val};
        }
        if (curCount == maxCount){
            items.add(pre.val);
        }
        int[] res = new int[items.size()];
        for (int i = 0;i < items.size();i++){
            res[i] = items.get(i);
        }

        return res;
    }

    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        if (pre != null){
            if (root.val != pre.val){
                if (curCount > maxCount){
                    maxCount = curCount;
                    items.clear();
                    items.add(pre.val);
                }else if (curCount == maxCount){
                    items.add(pre.val);
                }
                curCount = 1;
            }else {
                curCount++;
            }
        }
        pre = root;
        inorder(root.right);
    }
}

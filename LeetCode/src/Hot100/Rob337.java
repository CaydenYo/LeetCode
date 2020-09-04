package Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/7/11 12:08 下午
 */
public class Rob337 {
    /**
     * 明确相邻节点不能偷，也就是爷爷选择偷，儿子就并不能偷了，但是孙子可以偷
     * 二叉树只有左右两个孩子，一个爷爷最多4个孙子，2个儿子
     * 根据以上条件，可以得出单个节点的钱该怎么算
     * 爷爷的钱 + 4个孙子偷的钱 VS 2个儿子偷的钱
     * 哪个组合钱多，就当做当前节点能偷的最大钱数
     * */
    public int rob(TreeNode root){
        if (root == null){
            return 0;
        }
        int res1 = root.val;
        if (root.left != null){
            res1 = res1 + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null){
            res1 = res1 + rob(root.right.left) + rob(root.right.right);
        }

        int res2 = rob(root.left) + rob(root.right);

        return Math.max(res1, res2);
    }

    /***
     * 在上述方法中，在计算爷爷能偷多少钱是，同时计算了4个孙子和2个儿子能偷多少钱，
     * 这样在儿子当节点时会重复计算孙子节点
     * 所以我们需要做记忆化，一般记忆化是用数组来储存结果
     * 但是二叉树不适合用数组，因此使用哈希表来存储结果，TreeNode当做key，能偷的最大钱数当做value
     */
    Map<TreeNode, Integer> hashMap = new HashMap<>();
    public int rob1(TreeNode root){
        if (root == null){
            return 0;
        }
        if (hashMap.containsKey(root)){
            return hashMap.get(root);
        }
        int res1 = root.val;
        if (root.left != null){
            res1 = res1 + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null){
            res1 = res1 + rob(root.right.left) + rob(root.right.right);
        }

        int res2 = rob(root.left) + rob(root.right);
        int result = Math.max(res1, res2);
        hashMap.put(root, result);
        return result;
    }

    /**
     * 上述两种解法都用到了孙子节点，计算了爷爷节点还要同时计算孙子节点
     * 虽然有了记忆化，但是还是有性能损耗。这里换一种办法来定义状态
     * 每个节点可选择偷或者不偷
     * 如果当前节点偷，那么两个孩子节点就不能选择偷
     * 如果当前节点不偷，那么两个孩子节点只需要拿最多的钱出来就行了(注意：两个孩子节点也可以选择偷或者不偷)
     * 使用一个大小为2的数组来表示int[] res = new int[2]，0代表不偷，1代表偷
     * */
    public int rob2(TreeNode root){
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null){
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }

}

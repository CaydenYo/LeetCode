package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/12 10:45 下午
 */
public class PathSum437 {
    /**
     * 双递归
     * 路径不需要从根节点开始，也不需要在叶节点结束，但是路径方向必须是向下的(只能从父节点到子节点)
     * 所以就有三种情况：
     * 1. 以当前节点作为头结点的路径数量
     * 2. 以当前节点的左孩子作为头结点的路径数量
     * 3. 以当前节点的右孩子作为头结点的路径数量
     * 以上三种情况属于第一层递归，需要对root，root.left，root.right递归
     * 但是对于每一种情况来说，我们又要用到递归来计算sum的情况，如果sum == 0那么就算找到一条路径
     * 所以说每种情况里面需要用到第二层递归，这就是双递归
     * 将三部分之和作为最后结果返回即可
     * */
    int pathNumber = 0;
    public int pathSum(TreeNode root, int sum){
        if (root == null){
            return 0;
        }
        countSum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return pathNumber;
    }

    private void countSum(TreeNode root, int target) {
        if (root == null){
            return;
        }
        int sum = target - root.val;
        if (sum == 0){
            pathNumber += 1;
        }
        countSum(root.left, sum);
        countSum(root.right,sum);
    }
}

package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/18 5:56 下午
 */
public class AllPossibleFBT894 {
    /**
     * 一个满二叉树的节点数量不可能是偶数，因为永远多一个(根)，所以如果节点数为偶数直接返回
     * 如果要构建一个满二叉树首先应该new一个根节点root，然后为它构建左子树和右子树
     * 对于左子树而言，同样需要构建左子树的左子树和左子树的右子树，右子树同理。
     * 注意此处的左子树和右子树必须同步，要么全部存在，要么全部为null，这样构建出来的才是满二叉树
     *
     * 而如果要为某个节点分配i个左节点，那么一定要为它分配(N - 1 - i)个右节点。然后递归构造左右子树
     * 注意，i的循环递增数目应为2，因为如果想为某节点多分配一些左节点，那么一定要左右节点一起分配，也就是一次要加2
     * */
    public List<TreeNode> allPossibleFBT(int N){
        List<TreeNode> res = new ArrayList<>();
        if ((N & 1) == 0){
            return res;
        }
        if (N == 1){
            TreeNode head = new TreeNode(0);
            res.add(head);
            return res;
        }
        for (int i = 1;i < N;i += 2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode head = new TreeNode(0);
                    head.left = l;
                    head.right = r;
                    res.add(head);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new AllPossibleFBT894().allPossibleFBT(7).size());
    }
}

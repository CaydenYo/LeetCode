package Hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author cayden
 * @Date 2020/7/1 12:31 下午
 */
public class Flatten114 {
    /**
     * 将左子树插入到右子树的地方
     * 将原来的右子树接到左子树的最右边节点
     * 考虑新的右子树的根节点，重复以上步骤
     * */
    public void flatten(TreeNode root){
        while (root != null){
            // 左子树为null，直接考虑下一个节点
            if (root.left == null){
                root = root.right;
            }else {
                // 找到左子树的最右节点
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                // 将原来根节点的右子树接到左子树的最右节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

    /**
     * 如果直接用先序遍历的顺序，遍历到2就将1的右指针指向2
     * 遍历到3就把2的右指针指向3
     * 但是如果我们把1的右指针指向3那么1原本的右子树就会丢失
     * 所以我们可以用一个变形的后序遍历来实现
     *
     * 依次遍历6 5 4 3 2 1
     * 遍历到5把5的右指针指向6，遍历到4把4的右指针指向5
     * 这样就不会有丢失孩子的问题了，因为更新当前右指针的时候，当前节点的右孩子已经被访问过了
     * 遍历顺序是右子树->左子树->根节点
     * */
    private TreeNode pre = null;
    public void flatten1(TreeNode root){
        if (root == null){
            return;
        }
        flatten1(root.right);
        flatten1(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public void flatten2(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode pre = null;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                // 添加根节点
                stack.addLast(curr);
                // 递归添加右节点
                curr = curr.right;
            }
            // 已经访问到最右节点了
            curr = stack.peekLast();
            // 在不存在左节点或者左节点已经被访问过的情况下，访问根节点
            if (curr.left == null || curr.left == pre){
                curr = stack.pollLast();
                curr.right = pre;
                curr.left = null;
                pre = curr;
                // curr置为null让新一轮循环直接访问栈顶元素
                curr = null;
            }else {
                curr = curr.left;
            }
        }
    }

    /**
     * 还有一种特殊的先序遍历，
     * 提前将右孩子保存到栈中，
     * 我们利用这种遍历方式就可以防止右孩子的丢失了。
     * 由于栈是先进后出，所以我们先将右节点入栈。
     *
     * 因为我们用栈保存了右孩子，
     * 所以不需要担心右孩子丢失了。
     * 用一个 pre 变量保存上次遍历的节点
     * */
    public void flatten3(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            /***********修改的地方*************/
            if(pre!=null){
                pre.right = temp;
                pre.left = null;
            }
            /********************************/
            if (temp.right != null){
                s.push(temp.right);
            }
            if (temp.left != null){
                s.push(temp.left);
            }
            /***********修改的地方*************/
            pre = temp;
            /********************************/
        }
    }

    public void flatten4(TreeNode root) {
        root = dfs(root);
    }

    public TreeNode dfs(TreeNode root){
        if(root==null) return null;
        TreeNode left=dfs(root.left);
        TreeNode right=dfs(root.right);
        if(left!=null){
            root.right=left;
            TreeNode curr=root;
            while(curr.right!=null) curr=curr.right;
            curr.right=right;
            root.left=null;
        }
        return root;
    }
}

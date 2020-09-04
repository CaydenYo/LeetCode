package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cayden
 * @Date 2020/8/5 6:40 下午
 */
public class ConstructMaximumBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums){
        if (nums.length == 1){
            return new TreeNode(nums[0]);
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int low, int high){
        if (low > high){
            return null;
        }
        int maxIdx = findMax(nums, low, high);
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = construct(nums, low, maxIdx - 1);
        root.right = construct(nums, maxIdx + 1, high);
        return root;
    }

    private int findMax(int[] nums, int low, int high){
        int max = low;
        int index = low;
        while (index <= high){
            if (nums[index] > nums[max]){
                max = index;
            }
            index++;
        }
        return max;
    }

    /**
     * 采用一个单调递减栈，保证栈底是最大的值
     * 从头遍历数组，当前最大的值为根节点
     * 每次入栈前先和栈顶元素作比较，如果比它小则这个元素一定在在它右子树，直接赋值为右子树然后入栈
     * 如果当前的值比栈顶的大那么栈顶元素一定是当前值的左子树，一直出栈切更新左子树的根节点直到没有值比当前元素大
     * 当出栈完毕后，当前值就是栈顶元素右子树中的最大值，所以更新栈顶元素的右子树根节点为当前值并且入栈
     * 遍历结束后栈底只剩下最大的元素即整棵树的根节点
     * */
    public TreeNode constructMaximumBinaryTree1(int[] nums){
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int i = 0;i < nums.length;i++){
            TreeNode node = new TreeNode(nums[i]);
            while (!stack.isEmpty() && node.val > stack.peek().val){
                node.left = stack.pop();
            }
            if (!stack.isEmpty()){
                stack.peek().right = node;
            }
            stack.push(node);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }
}

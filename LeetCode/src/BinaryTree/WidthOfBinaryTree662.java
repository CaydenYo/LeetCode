package BinaryTree;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/8/6 4:56 下午
 */
public class WidthOfBinaryTree662 {
    public int widthOfBinaryTree(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        int res = 1;
        queue.add(root);
        map.put(root, 1);
        while (!queue.isEmpty()){
            int count = queue.size();
            int min = 0, max = 0;
            for (int i = 0;i < count;i++){
                TreeNode node = queue.poll();
                int pos = map.get(node);
                if (i == 0){
                    min = pos;
                }
                if (i == count - 1){
                    max = pos;
                }
                if (node.left != null){
                    queue.offer(node.left);
                    map.put(node.left, pos * 2 - 1);
                }
                if (node.right != null){
                    queue.offer(node.right);
                    map.put(node.right, pos * 2);
                }
            }
            res = Math.max(res, max - min + 1);
        }
        return res;
    }

    /**
     * 根节点的位置为i，则左节点的index为 2 * i - 1，右节点的in的行为2 * i
     * 用一个list保存每层的最左端点，二叉树有x层则list的元素就应该有x个
     * 在dfs的过程中记录每个节点的index和所在层，如果level > list.size()证明这一层还未被遍历
     * 那么第一个节点就是新一层的最左节点，于是将其放入list中
     * 否则判断当前节点的index减去list中对应层的最左节点的index得到宽度与max作比较
     * */
    int max = 1;
    public int widthOfBinaryTree1(TreeNode root){
        dfs(root, 1, 1, new ArrayList<>());
        return max;
    }

    private void dfs(TreeNode root, int level, int index, ArrayList<Integer> left) {
        if (root == null){
            return;
        }
        if (level > left.size()){
            left.add(index);
        }
        max = Math.max(max, index - left.get(level - 1) + 1);
        dfs(root.left, level + 1, index * 2 - 1, left);
        dfs(root.right, level + 1, index * 2, left);
    }
}

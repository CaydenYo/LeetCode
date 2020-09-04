package BinaryTree;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/8/8 9:21 下午
 */
public class ConstructFromPrePost889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post){
        int N = pre.length;
        if (N == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1){
            return root;
        }

        int L = 0;
        for (int i = 0;i < N;i++){
            if (post[i] == pre[1]){
                L = i + 1;
                break;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1),
                                            Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N),
                                            Arrays.copyOfRange(post, L, N - 1));

        return root;
    }
}

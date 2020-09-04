package Hot100;

import java.util.List;

/**
 * @Author cayden
 * @Date 2020/6/30 1:31 下午
 */
public class DifferentBST96 {
    /**
     * 搜索二叉树的特性，根左子树的值小于根，根you左子树的值大于根(即类似于有序序列)
     * 所以给定一个有序序列[1...n]，根据此序列构造搜索二叉树，
     * 我们可以遍历每个数字i，将该数字作为树根
     * 那么[1..i - 1]就成为了左子树，[i + 1...n]成为右子树
     * 可以根据此规律从子序列中递归得到大序列的数
     *
     * G(n)表示长度为n的序列的不同二叉树的个数
     * F(i, n)表示以i为根，长度为n的不同二叉树的个数
     *
     * G(n) = F(1, n) + F(2, n) + ... + F(n, n)
     *
     * 又得F(i, n) = G(i - 1) * G(n - i)
     *
     * */
    public int numTrees(int n){
        int[] G = new int[n + 1];

        G[0] = 1;
        G[1] = 1;

        for (int i = 2;i <= n;i++){
            for (int j = 1;j <= i;j++){
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}

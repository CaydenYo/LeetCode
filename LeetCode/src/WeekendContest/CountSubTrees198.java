package WeekendContest;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/7/19 2:35 下午
 */
public class CountSubTrees198 {
    int[] res;
    boolean[] visited;
    /**
     * 由于我们需要知道子树的情况，再将子树情况返回给根节点，所以使用后续dfs遍历
     * 由于只存在26个字母，因此可以使用一个26大小的int型数组存储标签
     * 统计节点底下出现的字母的情况，将这个节点的情况返回给父节点
     * 父节点在子节点的情况下加上自己的字母情况就得到了最终答案
     * */
    public int[] countSubTrees(int n, int[][] edges, String labels){
        // 创建邻接表，即图
        List<Integer>[] points = new List[n];
        for (int i = 0;i < n;i++){
            points[i] = new ArrayList<>();
        }
        // 记录某个节点的全部节点
        for (int[] p : edges){
            points[p[0]].add(p[1]);
            points[p[1]].add(p[0]);
        }

        // 将labels从string转成数组，这样方便获取
        int[] ls = new int[n];
        for (int i = 0;i < n;i++){
            ls[i] = labels.charAt(i) - 'a';
        }

        res = new int[n];
        visited = new boolean[n];
        dfs(0, points, ls);
        return res;
    }

    private int[] dfs(int i, List<Integer>[] points, int[] ls){
        // 标记访问
        visited[i] = true;
        int[] c = new int[26];
        for (int p : points[i]){
            // 如果子节点没有被访问过就可继续执行
            if (!visited[p]){
                int[] tmp = dfs(p, points, ls);
                for (int j = 0;j < 26;j++){
                    // 父节点累加子节点的情况
                    c[j] += tmp[j];
                }
            }
        }
        // 父节点将自身字母加入到当前情况
        c[ls[i]]++;
        // 实时更新res
        res[i] = c[ls[i]];
        // 返回当前节点情况给上层
        return c;
    }


    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{0,3}};
        String labels = "bbbb";
        int n = 4;
        int[] ans = new CountSubTrees198().countSubTrees(n, edges, labels);

        for (int a : ans){
            System.out.println(a);
        }
    }
}

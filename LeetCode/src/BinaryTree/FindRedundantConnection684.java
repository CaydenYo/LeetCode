package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/14 4:04 下午
 */
public class FindRedundantConnection684 {
    /**
     * 利用并查集来检查环
     * 首先初始化并查集，每个点的集合节点都是自己
     * 然后遍历每一条边，获得边中的两个端点
     * 分别查找两个端点的集合节点
     * 如果两个集合节点不相等，那就让其中一个点的集合节点等于另一个点的集合节点，因为它们连在一起了
     * 如果两个集合节点相等，说明这两个点属于同一个集合，如果让这两个点连接就会形成环
     * 而促使形成环的边就是所谓的最后一条边，直接将它们返回
     * */
    int[] parent;
    public int[] findRedundantConnection(int[][] edges){
        int length = edges.length;
        parent = new int[length + 1];
        for (int i = 0;i <= length;i++){
            parent[i] = i;
        }

        for (int i = 0;i < length;i++){
            int parent1 = findParent(edges[i][0]);
            int parent2 = findParent(edges[i][1]);
            if (parent1 == parent2){
                return edges[i];
            }else {
                parent[parent1] = parent2;
            }
        }
        return new int[]{0, 0};
    }

    private int findParent(int num){
        while (num != parent[num]){
            num = parent[num];
        }
        return num;
    }
}

package Hot100;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/7/12 10:25 上午
 */
public class CalcEquation399 {
    /**
     * 图解法：
     * 用Map1<String, Map2<String, Double>>表示图
     * Map1里的String代表开始节点，Map2里的String代表结束节点，Double代表从开始节点到结束节点这条边的权重
     * 由于是无向边，所以每次往图中加入边时要同时插入双向边，也就是两条边
     * 在DFS中遍历边时要加一个访问数组，表示该节点是否已经被访问过了
     * 如果没有访问过，才继续访问它的边
     * */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        Map<String, Map<String, Double>> graph = doGraph(equations, values);
        double[] res = new double[queries.size()];
        int index = 0;
        for (List<String> q : queries){
            res[index++] = dfs(graph, new HashSet<>(), q.get(0), q.get(1), 1);
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> graph, HashSet<String> visited, String start, String end, double ans) {
        if (!graph.containsKey(start) || !graph.containsKey(end)){
            return -1;
        }
        Map<String, Double> edges = graph.get(start);
        for (String key : edges.keySet()){
            if (!visited.contains(key)){
                visited.add(key);
                double v = edges.get(key);
                if (key.equals(end)){
                    return ans * v;
                }
                // 如果没找到end点就继续遍历当前的点的边
                double d = dfs(graph, visited, key, end, ans * v);
                if (d != -1){
                    return d;
                }
            }
        }
        return -1;
    }

    private Map<String, Map<String, Double>> doGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0;i < equations.size();i++){
            String s = equations.get(i).get(0);
            String t = equations.get(i).get(1);
            double val = values[i];
            // 因为是无向边，所以要加入两条边
            Map<String, Double> edge1 = graph.getOrDefault(s, new HashMap<>());
            edge1.put(t, val);
            graph.put(s, edge1);
            Map<String, Double> edge2 = graph.getOrDefault(t, new HashMap<>());
            edge2.put(s, 1/val);
            graph.put(t, edge2);
        }
        return graph;
    }


    /**
     * 并查集
     * 带权并查集问题，构建有向图
     * */
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 第 1 步：给每一个字符串生成一个 id ，方便在并查集中做操作
        int equationsSize = equations.size();
        Map<String, Integer> hashMap = new HashMap<>();
        UnionFind unionFind = new UnionFind(2 * equationsSize);

        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0;
            } else {

                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }


    private class UnionFind {

        private int[] parent;

        /**
         * 把父结点作为分母时的商
         */
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
            // 需要列方程计算
            weight[rootX] = weight[y] * value / weight[x];
        }

        public int find(int x) {
            if (x != parent[x]) {
                // 难点：这里维护 weight 的定义
                int origin = parent[x];
                parent[x] = find(parent[x]);

                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}

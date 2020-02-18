package DFS;

import java.util.Arrays;

public class CriticalConnections1192 {
    public Edge[] edges;
    public int cnt;
    public int[] fir;
    static class Edge{
        int u, v, w, next;
        boolean cut;
        int num;
    }

    int[] low;
    int[] dfn;
    int recdfn;

    void tarjanAddEdge(int u, int v, int w){
        edges[cnt] = new Edge();
        edges[cnt].u = u;
        edges[cnt].v = v;
        edges[cnt].w = w;
        edges[cnt].cut = false;
        edges[cnt].num = 0;
        edges[cnt].next = fir[u];
        fir[u] = cnt++;
    }

    public void initTarjan(int nodeSize, int edgeSize){
        cnt = 0;
        edges = new Edge[edgeSize + 10];
        low = new int[nodeSize + 10];
        dfn = new int[nodeSize + 10];
        fir = new int[edgeSize + 10];
        Arrays.fill(fir, -1);
    }

    public void tarjan(int u, int fa){
        low[u] = dfn[u] = ++recdfn;
        int have = 0;
        for (int i = fir[u];i != - 1;i = edges[i].next){
            int v = edges[i].v;
            if (have == 0 && v == fa){
                have++;
                continue;
            }
            if (dfn[v] == 0){

            }
        }

    }
}

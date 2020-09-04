package Hot100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cayden
 * @Date 2020/7/4 5:53 下午
 */
public class canFinish207 {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        if (numCourses <= 0){
            return false;
        }
        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0){
            return true;
        }

        // 创建入度数组
        int[] inDegree = new int[numCourses];

        // 创建邻接表
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0;i < numCourses;i++){
            adj[i] = new HashSet<>();
        }

        for (int[] p : prerequisites){
            inDegree[p[0]] ++;
            adj[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 首先加入入度为0的节点
        for (int i = 0;i < numCourses;i++){
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }

        // 记录已经出队的课程数量
        int cnt = 0;
        while (!queue.isEmpty()){
            Integer top = queue.poll();
            cnt += 1;
            // 遍历当前出队节点的所有邻接点
            for (int successor : adj[top]){
                inDegree[successor]--;
                if (inDegree[successor] == 0){
                    queue.add(successor);
                }
            }
        }

        return cnt == numCourses;
    }

    /**
     * 深度优先遍历
     * 借助一个标志列表flags，用于判断每个节点i(课程)的状态：
     * 1. 未被DFS访问：i = 0
     * 2. 已被其他节点启动的DFS访问i = -1
     * 3. 已被当前节点启动的DFS访问：i = 1
     *
     * 对某个特定的节点执行DFS时
     * 当碰到flags[i] == 1时说明在本轮DFS中这个节点已经被访问第二次了
     * 即课程安排图有环直接返回false
     * 本轮结束后若没有发现环则将当前节点的flag置为-1返回true
     * 进行下个节点的DFS
     * */

    public boolean canFinishDFS(int numCourses, int[][] prerequisites){
        if (numCourses <= 0){
            return false;
        }
        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0){
            return true;
        }

        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0;i < numCourses;i++){
            adj[i] = new HashSet<>();
        }

        int[] flags = new int[numCourses];

        for (int[] p :prerequisites){
            adj[p[1]].add(p[0]);
        }

        for (int i = 0;i < numCourses;i++){
            if (!dfs(adj, flags, i)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(HashSet<Integer>[] adj, int[] flags, int i){
        if (flags[i] == -1){
            return true;
        }
        if (flags[i] == 1){
            return false;
        }
        flags[i] = 1;
        for (int successor : adj[i]){
            if (!dfs(adj, flags, successor)){
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}

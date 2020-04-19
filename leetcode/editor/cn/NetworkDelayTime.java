package leetcode.editor.cn;

import java.util.*;

/**
 * Created by liuzhugu on 2020/01/07.
 * 743. 网络延迟时间
 * 有 N 个网络节点，标记为 1 到 N。给定一个列表 times，表示信号经过有向边的传递时间。 
 * times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 * 现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        //得到各点之间距离的矩阵图
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1;i <= N;i ++) {
            for (int j = 1;j <= N;j ++) {
                graph[i][j] = -1;
            }
        }
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }
        //得到各点距离起点的最近距离
        int[] distance = new int[N + 1];
        Arrays.fill(distance,-1);
        for (int i = 1;i <= N;i ++) {
            distance[i] = graph[K][i];
        }
        distance[K] = 0;

        boolean[] visited = new boolean[N + 1];
        visited[K] = true;
        for (int i = 1;i <= N;i ++) {
            //找到距离起点最近的点
            int minDistance = Integer.MAX_VALUE;
            int minIndex = 1;
            for (int j = 1;j <= N;j ++) {
                //未访问过却与起点相连通的最小距离点
                if (visited[j] == false && distance[j] != -1 && distance[j] < minDistance) {
                    minDistance = distance[j];
                    minIndex = j;
                }
            }
            //下一步访问最小距离点
            visited[minIndex] = true;
            //根据该距离更新与该节点相连的节点距起点的最小距离
            for (int j = 1;j <= N;j ++) {
                if (visited[j] == false && graph[minIndex][j] != -1) {
                    int dis = distance[minIndex] + graph[minIndex][j];
                    if (distance[j] == -1) {
                        distance[j] = dis;
                    } else {
                        distance[j] = Math.min(distance[j],dis);
                    }
                }
            }
        }
        //遍历找到最大值
        int result = 0;
        for (int i = 1;i <= N;i ++) {
            if (distance[i] == -1) return -1;
            result = Math.max(result,distance[i]);
        }
        return result;
    }

    //dfs
//    Map<Integer,Integer> dist = new HashMap<>();
//    public int networkDelayTime(int[][] times, int N, int K) {
//        //数据准备 key=节点  value=该节点与其他网点的距离
//        Map<Integer,List<int[]>> graph = new HashMap<>();
//        for (int[] time : times) {
//            if (! graph.containsKey(time[0])) {
//                graph.put(time[0],new ArrayList<>());
//            }
//            graph.get(time[0]).add(new int[]{time[2],time[1]});
//        }
//        //其所连接的节点按距离从小到大排  遍历的时候从距离近的开始遍历
//        for (int node : graph.keySet()) {
//            Collections.sort(graph.get(node),(a,b) -> a[0] - b[0]);
//        }
//        for (int i = 1;i <= N;i ++) {
//            dist.put(i,Integer.MAX_VALUE);
//        }
//
//        //正式逻辑
//        dfs(graph,K,0);
//
//        //得到结果
//        int result = 0;
//        for (int dis : dist.values()) {
//            if (dis == Integer.MAX_VALUE) return -1;
//            result = Math.max(result,dis);
//        }
//        return result;
//    }

    //深度遍历
//    private void dfs(Map<Integer,List<int[]>> graph,int node,int ela) {
//        if (ela >= dist.get(node)) return;
//        dist.put(node,ela);
//        if (graph.containsKey(node)) {
//            for (int[] info : graph.get(node)) {
//                dfs(graph,info[1],ela + info[0]);
//            }
//        }
//    }
}

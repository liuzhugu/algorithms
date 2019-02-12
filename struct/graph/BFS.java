package struct.graph;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历
 * */
public class BFS {

    public static void visit(Graph graph,int s,int t){
        if(s==t){
            return;
        }
        //已访问的节点
        boolean[] visited=new boolean[graph.getV()];
        //等待遍历的节点
        Queue<Integer> waitToVisit=new LinkedList<>();
        //记录访问的顺序
        int[] pre=new int[graph.getV()];
        for(int i=0;i<graph.getV();i++){
            pre[i]=-1;
        }
        //从起点开始访问
        waitToVisit.add(s);
        visited[s]=true;
        while(!waitToVisit.isEmpty()){
            int current=waitToVisit.poll();
            //获取该节点所能到达的所有节点
            LinkedList<Integer> nextList=graph.getNextList(current);
            for(int next:nextList){
                //该下一个节点未被访问过
                if(!visited[next]){
                    //访问该节点
                    pre[next]=current;
                    //抵达终点
                    if(next==t){
                        //打印途经路径
                        print(pre,s,t);
                        return;
                    }
                    visited[next]=true;
                    waitToVisit.add(next);
                }
            }
        }
    }

    private static void print(int[] pre,int s,int t){
        if(pre[t]!=-1 && t!=s){
            print(pre,s,pre[t]);
        }
        System.out.print(t+" ");
    }

    public static void visit(DirectedGraph graph,int s,int t){

    }
}

package struct.graph;

import java.util.LinkedList;

/**
 * 有向图
 * */
public class DirectedGraph {

    //顶点个数
    private int v;

    //邻接表
    private LinkedList<Integer> adj[];

    public DirectedGraph(int v){
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }

    public void add(int s,int t){
        adj[s].add(t);
    }
}

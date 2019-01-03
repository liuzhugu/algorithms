package struct.graph;

import lombok.Data;

import java.util.LinkedList;

/**
 * 无向图
 * */
@Data
public class UndirectedGraph {

    //顶点个数
    private int v;

    //邻接表
    private LinkedList<Integer> adj[];

    public UndirectedGraph(int v){
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }

    public void add(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    public LinkedList<Integer> getNextList(int node){
        if(node<0||node>=v){
            return null;
        }
        return adj[node];
    }
}

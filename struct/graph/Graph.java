package struct.graph;

import lombok.Data;

import java.util.LinkedList;

@Data
public class Graph {
    //顶点个数
    protected int v;

    //邻接表
    protected LinkedList<Integer> adj[];

    public Graph(int v){
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }


    public LinkedList<Integer> getNextList(int node){
        if(node<0||node>=v){
            return null;
        }
        return adj[node];
    }

    public void add(int s,int t){}
}

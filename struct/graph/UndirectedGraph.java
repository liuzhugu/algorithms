package struct.graph;

import lombok.Data;

import java.util.LinkedList;

/**
 * 无向图
 * */
public class UndirectedGraph extends Graph{

    public UndirectedGraph(int v){
        super(v);
    }

    @Override
    public void add(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }
}

package struct.graph;

import java.util.LinkedList;

/**
 * 有向图
 * */
public class DirectedGraph extends Graph{


    public DirectedGraph(int v){
        super(v);
    }

    @Override
    public void add(int s,int t){
        adj[s].add(t);
    }
}

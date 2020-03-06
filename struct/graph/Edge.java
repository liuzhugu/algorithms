package struct.graph;

public class Edge {
    //边的起始顶点编号
    public int sid;
    //边的终止顶点编号
    public int tid;
    //边的权重
    public int w;

    public Edge(int sid, int tid, int w) {
        this.sid = sid;
        this.tid = tid;
        this.w = w;
    }
}

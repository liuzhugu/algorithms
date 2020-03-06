package struct.graph;

public class Vertex {
    //顶点编号ID
    public int id;
    //从起点到该顶点的距离
    public int dist;

    public Vertex(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
}

package struct.graph;

public class GraphTest {

    public static void main(String[] args){
//        int[][] nums=new int[][]{
//                {0,1,1,0},
//                {0,0,0,0},
//                {0,1,0,0},
//                {0,1,0,0}
//        };

        int[][] nums=new int[][]{
                {0,1,0,1,0},
                {0,0,0,0,1},
                {1,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0}
        };
        //UndirectedGraph graph=GraphUtil.buildUndirectedGraph(nums);
        DirectedGraph graph=GraphUtil.buildDirectedGraph(nums);


        //广度优先访问
        //BFS.visit(graph,0,4);

        //深度优先访问
        DFS.visit(graph,0,3);
    }
}

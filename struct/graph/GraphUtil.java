package struct.graph;

import java.util.Queue;

/**
 * 图工具类
 * */
public class GraphUtil {

    /**
     * 创建有向图
     * */
    public static DirectedGraph buildDirectedGraph(int[][] matrix){
        if(matrix==null){
            return null;
        }

        //判断是否是正方形
        for(int i=0;i<matrix.length;i++){
            if(matrix.length!=matrix[i].length){
                return null;
            }
        }

        DirectedGraph graph=new DirectedGraph(matrix.length);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    graph.add(i,j);
                }
            }
        }
        return graph;
    }


    /**
     * 创建无向图
     * */
    public static UndirectedGraph buildUndirectedGraph(int[][] matrix){
        if(matrix==null){
            return null;
        }

        //判断是否是正方形
        for(int i=0;i<matrix.length;i++){
            if(matrix.length!=matrix[i].length){
                return null;
            }
        }

        UndirectedGraph graph=new UndirectedGraph(matrix.length);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                //因为是无向图,是相对于矩阵的斜切对称的,所以只取一边,然后一次加两条
                if((i+j)<=matrix.length){
                    if(matrix[i][j]==1){
                        graph.add(i,j);
                    }
                }

            }
        }
        return graph;
    }
}

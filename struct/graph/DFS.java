package struct.graph;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 深度优先遍历
 * */
public class DFS {

    public static void visit(Graph graph,int s,int t){
        if(s==t){
            return;
        }
        //取所有下一步节点递归第深入访问
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        for(int next:graph.getNextList(s)){
            queue.add(next);
            visit(graph,next,t,queue);
            queue.remove(next);
        }
    }

    private static void visit(Graph graph,int s,int t,Queue<Integer> hasVisited){
        //抵达终点
        if(s==t){
            print(hasVisited);
        }
        //取所有下一步节点递归第深入访问
        for(int next:graph.getNextList(s)){
            //如果已经访问过了的话跳过该节点
            if(hasVisited.contains(next)){
                continue;
            }
            hasVisited.add(next);
            visit(graph,next,t,hasVisited);
            hasVisited.remove(next);
        }
    }

    private static void print(Queue<Integer> queue){
        if(queue.isEmpty()){
            return;
        }
        Iterator<Integer> iterator=queue.iterator();
        while(iterator.hasNext()){
            System.out.print(" "+iterator.next()+" ");
        }
        System.out.println();
    }

}

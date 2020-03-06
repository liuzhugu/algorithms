package struct.graph;

import java.util.Arrays;

//到起点距离的最小堆
public class PriorityQueue {
    
    private Vertex[] node;
    private int count;
    private static final int DEFAULT_SIZE = 16;
    private boolean isMax;

    public PriorityQueue(int v) {
        this.node = new Vertex[v + 1];
        this.count = v;
        isMax = false;
    }
    
    public Vertex peek(){
        if(count != 0) {
            return node[0];
        }
        return null;
    }

    public int count(){
        return count;
    }

    public Vertex poll(){
        if(peek() == null){
            return null;
        }else {
            Vertex value = peek();
            remove(value);
            return value;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(Vertex vertex){
        int i = count;
        if(i >= node.length){
            grow(i+1);
        }
        count = i+1;
        if(i == 0){
            node[0] = vertex;
        }else {
            siftUp(i,vertex);
        }
    }


    public void remove(Vertex vertex){
        int index = indexOf(vertex);
        if (index != -1){
            int s = -- count;
            if (s == index){
                //如果要删的是最后一个,那么就不用向下调整了
                node[s] = null;
            } else{
                Vertex replace = node[s];
                node[s] = null;
                siftDown(index,replace);
            }
        }
    }

    public void update(Vertex vertex) {
        int index = indexOf(vertex);
        if (index != -1){
            if (isMax) {
                if (vertex.dist > node[index].dist) {
                    siftUp(index,vertex);
                }else {
                    siftDown(index,vertex);
                }
            }else {
                if (vertex.dist > node[index].dist) {
                    siftDown(index,vertex);
                }else {
                    siftUp(index,vertex);
                }
            }
        }
    }


    //根据顶点id查找
    public int indexOf(Vertex vertex){
        for(int i = 0;i < count;i++){
            if(vertex.id == node[i].id){
                return i;
            }
        }
        return -1;
    }

    public void grow(int minCapacity){
        int oldCapacity = node.length;
        //小于64双倍,否则增长50%
        int newCapacity = oldCapacity + (oldCapacity < 64 ?
                (oldCapacity + 2) : oldCapacity >> 1);
        if(newCapacity < minCapacity) newCapacity = minCapacity;
        node = Arrays.copyOf(node,newCapacity);
    }


    public void headify(){
        for(int i = node.length >> 1;i >= 0;i --){
            //从中位开始往前,然后依次向下堆化
            siftDown(i,node[i]);
        }
    }

    /**
     * 向上堆化
     * @param index 要被替换的位置
     * @param replace 用于替换的元素
     * */
    public void siftUp(int index,Vertex replace){
        node[index] = replace;
        while(index > 0){
            int parent = (index - 1) / 2;
            if(isMax){
                if (node[parent].dist < node[index].dist) swap(index,parent);
            }else {
                if (node[parent].dist > node[index].dist) swap(index,parent);
            }
            index = parent;
        }
    }

    /**
     * 向下堆化
     * @param index 要被替换的位置
     * @param replace 用于替换的元素
     * */
    public void siftDown(int index,Vertex replace){
        node[index] = replace;
        while (index < node.length){
            int leftChild = index * 2 + 1,rightChild = leftChild + 1,tmpNo = index;
            if (isMax){
                if (leftChild < count && node[leftChild].dist > node[tmpNo].dist) tmpNo = leftChild;
                if (rightChild < count && node[rightChild].dist > node[tmpNo].dist) tmpNo = rightChild;
            }else {
                if (leftChild < count && node[leftChild].dist < node[tmpNo].dist) tmpNo = leftChild;
                if (rightChild < count && node[rightChild].dist < node[tmpNo].dist) tmpNo = rightChild;
            }
            if (tmpNo == index){
                break;
            }
            swap(index,tmpNo);
            index = tmpNo;
        }
    }

    private void swap(int first,int second){
        Vertex tmp = node[first];
        node[first] = node[second];
        node[second] = tmp;
    }
}

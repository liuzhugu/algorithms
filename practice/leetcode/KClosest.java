package practice.leetcode;

import java.util.*;

/**
 * Created by liuzhugu on 2019/03/27.
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length ==0 || K == 0) {
            return new int[][]{};
        }
        if (points.length <= K){
            return points;
        }
        //距离的最小堆,然后从最小堆取距离前k,然后找到这些距离对应的点
        Heap heap = new Heap(false);
        //key是距离的平方,value是相应的index列表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0;i < points.length;i ++) {
            int[] point = points[i];
            int distance = point[0] * point[0] + point[1] * point[1];
            heap.add(distance);
            List<Integer> indexs;
            if (map.get(distance) == null) {
                indexs = new ArrayList<>();
                indexs.add(i);
                map.put(distance,indexs);
            }else {
                indexs = map.get(distance);
                indexs.add(i);
            }
        }
        int[] distances = new int[K];
        for (int i = 0;i < K;i ++) {
            distances[i] = heap.poll();
        }
        int[][] result = new int[K][2];
        int i = 0,j = 0;
        while (i < K && j < distances.length) {
            List<Integer> indexs = map.get(distances[j ++]);
            for (int k = 0;k < indexs.size();k ++) {
                if (i < K) {
                    result[i] = points[indexs.get(k)];
                    i ++;
                }
            }
        }
        return result;
    }
}
class Heap {

    private int[] heap;

    private int size;

    private static final int DEFAULT_SIZE = 16;

    private boolean isMax;

    public Heap(){
        this(true);
    }
    public Heap(boolean isMax){
        heap = new int[DEFAULT_SIZE];
        size=0;
        this.isMax=isMax;
    }
    public Heap(int[] nums){
        this(nums,true);
    }
    public Heap(int[] nums,boolean isMax){
        if(nums!=null||nums.length!=0){
            heap= Arrays.copyOf(nums,nums.length);
            size=nums.length;
            //堆化
            headify();
        }
        this.isMax=isMax;
    }

    public int peek(){
        if(size!=0) {
            return heap[0];
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public int poll(){
        if(peek()==-1){
            return -1;
        }else {
            int value=peek();
            remove(value);
            return value;
        }
    }

    public void add(int num){
        int i=size;
        if(i>=heap.length){
            grow(i+1);
        }
        size=i+1;
        if(i==0){
            heap[0]=num;
        }else {
            siftUp(i,num);
        }
    }


    public void remove(int num){
        int index=indexOf(num);
        if(index!=-1){
            int s=--size;
            if(s==index){
                //如果要删的是最后一个,那么就不用向下调整了
                heap[s]=0;
            }else{
                int replace=heap[s];
                heap[s]=0;
                siftDown(index,replace);
            }
        }
    }

    public int indexOf(int num){
        for(int i=0;i<size;i++){
            if(num==heap[i]){
                return i;
            }
        }
        return -1;
    }

    public void grow(int minCapacity){
        int oldCapacity = heap.length;
        //小于64双倍,否则增长50%
        int newCapacity = oldCapacity+(oldCapacity<64?
                (oldCapacity+2):oldCapacity>>1);
        if(newCapacity<minCapacity)newCapacity=minCapacity;
        heap=Arrays.copyOf(heap,newCapacity);
    }


    public void headify(){
        for(int i=heap.length>>1;i>=0;i--){
            //从中位开始往前,然后依次向下堆化
            siftDown(i,heap[i]);
        }
    }

    /**
     * 向上堆化
     * @param index 要被替换的位置
     * @param replace 用于替换的元素
     * */
    public void siftUp(int index,int replace){
        heap[index]=replace;
        while(index>0){
            int parent = (index - 1) / 2;
            if(isMax){
                if(heap[parent]<heap[index]) swap(index,parent);
            }else {
                if(heap[parent]>heap[index]) swap(index,parent);
            }
            index=parent;
        }
    }

    /**
     * 向下堆化
     * @param index 要被替换的位置
     * @param replace 用于替换的元素
     * */
    public void siftDown(int index,int replace){
        heap[index]=replace;
        while(index<heap.length){
            int leftChild=index*2+1,rightChild=leftChild+1,tmpNo=index;
            if(isMax){
                if(leftChild<size&&heap[leftChild]>heap[tmpNo])tmpNo=leftChild;
                if(rightChild<size&&heap[rightChild]>heap[tmpNo])tmpNo=rightChild;
            }else {
                if(leftChild<size&&heap[leftChild]<heap[tmpNo])tmpNo=leftChild;
                if(rightChild<size&&heap[rightChild]<heap[tmpNo])tmpNo=rightChild;
            }
            if(tmpNo==index){
                break;
            }
            swap(index,tmpNo);
            index=tmpNo;
        }
    }

    private void swap(int first,int second){
        int tmp=heap[first];
        heap[first]=heap[second];
        heap[second]=tmp;
    }

    public void print(){
        System.out.print(Arrays.toString(Arrays.copyOf(heap,size)).replace("[","").replace("]",""));
    }
}

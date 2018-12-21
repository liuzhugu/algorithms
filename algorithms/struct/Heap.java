package algorithms.struct;

import java.util.Arrays;

/**
 * 最大堆
 * */
public class Heap {

    private int[] heap;

    private int size;

    private static final int DEFAULT_SIZE = 16;

    public Heap(){
        heap = new int[DEFAULT_SIZE];
        size=0;
    }

    public Heap(int[] nums){
        if(nums!=null||nums.length!=0){
            heap=Arrays.copyOf(nums,nums.length);
            size=nums.length;
            //堆化
            headify();
        }
    }

    public int peek(){
        if(size!=0) {
            return heap[0];
        }
        return -1;
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
            int parent=index/2;
            if(heap[parent]<heap[index]) swap(index,parent);
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
            if(leftChild<heap.length&&heap[leftChild]>heap[tmpNo])tmpNo=leftChild;
            if(rightChild<heap.length&&heap[rightChild]>heap[tmpNo])tmpNo=rightChild;
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

    @Override
    public String toString(){
        return heap.toString();
    }
}

package algorithms.za;

import algorithms.struct.Heap;


public class Median {
    private Heap maxHeap=new Heap();
    private Heap minHeap=new Heap(false);

    private int median=-1;

    public int getMedian(){
        return median;
    }

    public void add(int num){
        if(median==-1){
            median=num;
            return;
        }

        if(num>median){
            //放入最小堆
            minHeap.add(num);
        }else {
            //放入最大堆
            maxHeap.add(num);
        }

        //如果加完之后两个堆的大小不平衡,需要调整
        if(Math.abs(maxHeap.size()-minHeap.size())>=2){
            if(maxHeap.size()>minHeap.size()){
                //将原来的中值加入最小堆
                minHeap.add(median);
                //取出最大堆的最大值作为中值
                this.median=maxHeap.poll();
            }else {
                //将原来的中值加入最大堆
                maxHeap.add(median);
                //取出最小堆的最小值作为中值
                this.median=minHeap.poll();

            }
        }
    }

    public void print(){
        maxHeap.print();
        System.out.print(" ["+median+"] ");
        minHeap.print();
    }
}

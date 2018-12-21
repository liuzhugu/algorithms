package algorithms.struct;

public class Test {

    public static void main(String[] args){
//        Heap heap=new Heap();
//        heap.add(1);
//        heap.add(9);
//        heap.add(3);
//        heap.add(2);
//        heap.add(6);
//        heap.add(5);
//        heap.add(7);
//        heap.add(8);
//        heap.remove(8);
//        heap.remove(1);
//        heap.add(8);
        Heap heap=new Heap(new int[]{1,45,778,22,12,41,33,99,11,25,88});

        System.out.println(heap.toString());

        int num;
        while((num=heap.peek())!=-1){
            System.out.print(num+" ");
            heap.remove(num);
        }
    }
}

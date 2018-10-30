package algorithms.sort;

public class Test {

    public static void main(String[] args){

        int[] nums=new int[]{1,5,7,2,4,3,8,9,6,0,1,3,4,5};
        int[] result;

        //BubbleSort
        //printResult("BubbleSort",BubbleSort.bubbleSort(nums));

        //SelectSort
        //printResult("SelectSort",SelectSort.selectSort(nums));

        //InsertSort
        //printResult("InsertSort",InsertSort.insertSort(nums));

        //ParadiseSort
        printResult("ParadiseSort",ParadiseSort.paradiseSort(nums));

    }

    public static void printResult(String name,int[] result){
        System.out.println(name+" result:");
        for(int a:result){
            System.out.print(a+" ");
        }
    }
}

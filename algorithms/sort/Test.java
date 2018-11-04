package algorithms.sort;

public class Test {

    public static void main(String[] args){

        int[] nums=new int[]{4,5,6,7,3,2,3,4,6,-1,-1,-2,-2};

        //BubbleSort
        //printResult("BubbleSort",BubbleSort.sort(nums));

        //SelectSort
        //printResult("SelectSort",SelectSort.sort(nums));

        //InsertSort
        //printResult("InsertSort",InsertSort.sort(nums));

        //ParadiseSort
        //printResult("ParadiseSort",ParadiseSort.sort(nums));

        //QuickSort
        //printResult("QuickSort",QuickSort.sort(nums));

        //Quick3Way
        //printResult("Quick3Way",Quick3Way.sort(nums));

        //CountingStar
        printResult("CountingStar",CountingStar.sort(nums));
    }

    public static void printResult(String name,int[] result){
        System.out.println(name+" result:");
        for(int a:result){
            System.out.print(a+" ");
        }
    }
}

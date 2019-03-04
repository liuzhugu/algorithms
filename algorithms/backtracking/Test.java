package algorithms.backtracking;

public class Test {

    public static void main(String[] args){
        //0-1背包问题
        int[] items=new int[]{1,7,5,8,11,3,6};
        System.out.println(Knapsack.findMaxWeight(items,33));
//        for(int i=10;i<50;i++){
//            int j=Knapsack.findMaxWeight(items,i);
//            if(i!=j){
//                System.out.println(i);
//                break;
//            }
//
//        }
    }
}

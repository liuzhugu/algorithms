package algorithms.search;

import algorithms.sort.CountingSort;

public class Test {

    public static void main(String[] args){

        int[] nums=new int[]{1,3,6,8,9,11,16,16,16,16};

//        System.out.println(BinarySearch.bsearch(nums,18));
//        System.out.println(BinarySearch.bsearchInternally(nums,16));
//        System.out.println(BinarySearch.findFirst(nums,16));
//        System.out.println(BinarySearch.findLast(nums,16));
        System.out.println(BinarySearch.bsearchInternally(nums,9));

    }
}

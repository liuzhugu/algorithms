package algorithms.sort;

/**
 *  Created by liuzhugu on 2018/10/30
 *  归并算法
 *  平均时间复杂度:O(nlogn)
 *  最坏时间复杂度:O(nlogn)
 *  非原地排序，需空间O(n)
 *  合并的时候，如果相等，左边有限，稳定排序
 *  虽然最坏也是O(nlogn)，但非原地，额外需要空间
 *  数据量比较少的时候适合，但一般都选择快排
 */
public class ParadiseSort {

    public static int[] paradiseSort(int[] nums){
        if(nums==null||nums.length<2){
            return nums;
        }

        insertSort(nums,0,nums.length-1);
        return nums;
    }

    public static void insertSort(int[] nums,int start,int end){
        if(start==end){
            return;
        }
        int medium=(start+end)/2;
        insertSort(nums,start,medium);
        insertSort(nums,medium+1,end);
        merge(nums,start,medium,medium+1,end);
    }

    //合并
    private static void merge(int[] nums,int firstStart,int firstEnd,int secondStart,int secondEnd){
        int[] result=new int[secondEnd-firstStart+1];
        int index=secondEnd-firstStart;
        while(firstEnd>=firstStart&&secondEnd>=secondStart){
            if(nums[firstEnd]>nums[secondEnd]){
                result[index--]=nums[firstEnd--];
            }else {
                result[index--]=nums[secondEnd--];
            }
        }
        if(firstEnd<firstStart){
            while(secondEnd>=secondStart){
                result[index--]=nums[secondEnd--];
            }
        }

        if(secondEnd<secondStart){
            while(firstEnd>=firstStart){
                result[index--]=nums[firstEnd--];
            }
        }

        //拷贝回来
        index++;
        while(index<result.length){
            nums[firstStart++]=result[index++];
        }
    }
}

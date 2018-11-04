package algorithms.sort;

import java.util.Random;

/**
 *  Created by liuzhugu on 2018/10/30
 *  快排算法
 *  平均时间复杂度:O(nlogn)
 *  最坏时间复杂度:O(n²)
 *  非稳定排序
 *  原地排序
 */
public class QuickSort {

    public static int[] sort(int[] nums){
        if(nums==null||nums.length<2){
            return nums;
        }
        sort(nums,0,nums.length-1);
        return nums;
    }

    public static void  sort(int[] nums,int start,int end){
        if(start>=end){
            return ;
        }
        int k=partition(nums,start,end);
        sort(nums,start,k-1);
        sort(nums,k+1,end);
    }

    public static int partition(int[] nums,int start,int end){
        int pre=start,next=end+1;
        int value=nums[start];
        while(true){
            //因为最终要把指针停止的地方放到开始的地方，所以得从左开始找
            //那么有两种情况
            //从左边找到比value大的，再从右边找到比value小的，两者交换
            while(nums[++pre]<value){
                if(pre==end){
                    break;
                }
            }
            while(nums[--next]>value){
                if(next==start){
                    break;
                }
            }
            if(pre>=next){
                break;
            }
            int tmp=nums[pre];
            nums[pre]=nums[next];
            nums[next]=tmp;
        }
        int tmp=nums[start];
        nums[start]=nums[next];
        nums[next]=tmp;
        return next;
    }
}

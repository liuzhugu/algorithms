package algorithms.sort;


/**
 *  Created by liuzhugu on 2018/10/27
 *  冒泡算法
 *  平均时间复杂度:O(n²)
 *  最坏时间复杂度:O(n²)
 *  原地排序
 *  碰到相等情况不交换，所以是稳定排序
 *  相比于插入排序，交换的操作太多，虽然时间复杂度级别一样但系数不一样
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] nums){

        if(nums==null||nums.length<2){
            return nums;
        }

        //该层循环代表总共要排的数，循环的目的是对每个数处理
        for(int i=0;i<nums.length;i++){
            //该层循环代表待排的数，循环的目的是找到未排的数中最大的数，将其放到结尾
            //优化，如果在该次比较中全部有序，那么后面就不用比较了
            boolean isExchange=false;
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    isExchange = true;
                }
            }
            if(!isExchange){
                break;
            }

        }

        return nums;
    }
}

package algorithms.sort;


/**
 *  Created by liuzhugu on 2018/10/30
 *  桶排序
 *  平均时间复杂度:O(n)
 *  最坏时间复杂度:O(n)
 *  查找位置时因为是从最大的开始，所以可以从原数组倒着找位置，所以是稳定排序
 *  要一个额外的数组存放，所以是非原地排序
 */
public class CountingStar {

    public static int[] sort(int[] nums){

        if(nums==null||nums.length<2){
            return nums;
        }

        int max=nums[0],min=nums[0];
        //获取桶的大小,取决于最大和最小之差
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        int[] count=new int[max-min+2];
        //统计元素
        for(int i=0;i<nums.length;i++){
            //表示该数计数+1
            count[nums[i]-min+1]++;
        }
        for(int i=2;i<count.length;i++){
            count[i]=count[i-1]+count[i];
        }
        //统计完之后就可以确定各数的位置了
        int[] newNums=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            newNums[count[nums[i]-min+1]-1]=nums[i];
            count[nums[i]-min+1]--;
        }
        return newNums;
    }
}

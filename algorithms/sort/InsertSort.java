package algorithms.sort;

/**
 *  Created by liuzhugu on 2018/10/30
 *  冒泡算法
 *  平均时间复杂度:O(n²)
 *  最坏时间复杂度:O(n²)
 *  原地排序
 *  在前者小于等于自己，，所以是稳定排序
 *  找到待插入的目的地以后才插入，交换操作少很多
 */
public class InsertSort {
    public static int[] sort(int[] nums){
        if(nums==null||nums.length<2){
            return nums;
        }
        for(int i=1;i<nums.length;i++){
            int value=nums[i];
            int j=i-1;
            for(;j>=0;j--){
                if(value>=nums[j]){
                    move(nums,j+1,i);
                    nums[j+1]=value;
                    break;
                }
            }
            if(j==-1){
                move(nums,0,i);
                nums[0]=value;
            }
        }
        return nums;
    }

    private static int[] move(int[] nums,int start,int end){
        for(;end>start;end--){
            nums[end]=nums[end-1];
        }
        return nums;
    }
}

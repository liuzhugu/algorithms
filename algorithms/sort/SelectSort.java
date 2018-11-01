package algorithms.sort;

/**
 *  Created by liuzhugu on 2018/10/27
 *  选择算法
 *  平均时间复杂度:O(n²)
 *  最坏时间复杂度:O(n²)
 */

public class SelectSort {

    public static int[] sort(int[] nums){

        if(nums==null||nums.length<2){
            return nums;
        }

        //该层循环代表总共要排的数，循环的目的是对每个数处理
        for(int i=0;i<nums.length;i++){
            //遍历比较，找到最大的数，最后放到队尾
            //因为队尾的数最终会被覆盖，所以把队首当做最大值的初始值，然后把队尾的数放到队首
            int max=nums[0];
            nums[0]=nums[nums.length-i-1];
            for(int j=0;j<=nums.length-i-2;j++){
                if(nums[j]>max){
                    int tmp=max;
                    max=nums[j];
                    nums[j]=tmp;
                }
            }
            //最终得到的最大值放到队尾
            nums[nums.length-i-1]=max;

        }

        return nums;
    }
}

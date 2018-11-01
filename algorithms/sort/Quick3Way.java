package algorithms.sort;


/**
 *  Created by liuzhugu on 2018/11/01
 *  三向切分的快速排序
 *  适用于重复元素多的场景
 *
 */
public class Quick3Way {

    public static int[] sort(int[] nums){
        sort(nums,0,nums.length-1);
        return nums;
    }

    public static void sort(int[] nums,int lo,int hi){
        if(hi<=lo)return;
        int lt=lo,i=lo+1,gt=hi;
        int key=nums[lo];
        //lo至lt-1小于key  lt至i-1等于key i至gt-1未知 gt至hi大于key
        while(i<=gt){
            if(nums[i]>key){
                //将nums[i]大于key，增加gt至hi范围
                int tmp=nums[i];
                nums[i]=nums[gt];
                nums[gt]=tmp;
                gt--;
            }else if(nums[i]==key){
                //因为nums[i]等于key，增加lt至i-1范围
                i++;
            }else{
                //因为nums[i]小于key,增加lo至lt-1
                int tmp=nums[i];
                nums[i]=nums[lt];
                nums[lt]=tmp;
                lt++;
                i++;
            }
        }
        //等于key的部分不用排序了
        //把小于key的部分排下序
        sort(nums,lo,lt-1);
        //把大于key的部分排下序
        sort(nums,gt+1,hi);

    }
}

package practice.leetcode;

/**
 * Created by liuzhugu on 2019/03/31.
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        //快排
        sort(nums,0,nums.length - 1);
        return nums;
    }
    private void sort(int[] nums,int start,int end) {
        if (start >= end) return;
        int index = pick(nums,start,end);
        sort(nums,start,index - 1);
        sort(nums,index + 1,end);
    }
    private int pick(int[] nums,int start,int end) {
        if (start >= end) return start;
        int left = start,right = end;
        int goal = nums[start];
        while (left < right) {
            while (left < right && nums[right] >= goal) {
                right --;
            }
            if (start < right) {
                nums[start ++] = nums[right];
            }

            while (left < right && nums[left] <= goal) {
                left ++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
        }
        nums[left] = goal;
        return left;
    }
}

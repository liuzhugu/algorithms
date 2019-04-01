package practice.leetcode;

import java.util.Arrays;

/**
 * Created by liuzhugu on 2019/04/01.
 * 462. 最少移动次数使数组元素相等 II
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。
 * 您可以假设数组的长度最多为10000。
 */
public class MinMoves2 {
    //从大到小排序后，根据中轴两边对称的数，两边移动到最终相等的值的次数是一定的,等于两数的差值
    //如果中位数只有一个，把其作为最终相等的值，而且不影响其他数要移动的次数。
    //如果中位数由两个，那么这两个数要移动的次数仍然等于两数的差值
    public int minMoves2(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0,j = nums.length - 1;i < (nums.length -  1) / 2;i ++,j --){
            result = result + (nums[j] - nums[i]);
        }
        return result;
    }
}

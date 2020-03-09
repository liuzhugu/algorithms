package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/09.
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
 *  所有偶数位于数组的后半部分
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (left < right) {
            while (left < right) {
                //找到偶数
                if (nums[left] % 2 == 0) {
                    break;
                }
                left ++;
            }
            while (left < right) {
                //找到偶数
                if (nums[right] % 2 == 1) {
                    break;
                }
                right --;
            }
            //交换
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}

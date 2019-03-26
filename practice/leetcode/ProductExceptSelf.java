package practice.leetcode;

/**
 * Created by liuzhugu on 2019/03/26.
 *  238. 除自身以外数组的乘积
 * 给定长度为n的整数数组nums,其中n>1,返回输出数组output,其中output[i]等于nums中除nums[i]之外
 * 其余各元素的乘积.请不要使用除法，且在O(n)时间复杂度内完成此题。
 */
public class ProductExceptSelf {
    //思路   每个数的除自身以外数组的乘积等于左边所有数的乘积 * 右边所有数的乘积
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length - 1] =1;
        for (int i = 1;i < nums.length;i ++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2;i >= 0;i --) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0;i < nums.length;i ++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划

package leetcode.editor.cn;
//Java：152:乘积最大子数组 2020/04/30
public class MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        //TO TEST
        solution.maxProduct(new int[]{3,-2,-3,3,-1,0,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            //imin是为了保存负值
            int max = Integer.MIN_VALUE,imax = 1,imin = 1;
            for (int i = 0;i < nums.length;i ++) {
                if (nums[i] < 0) {
                    //负数应该乘小的 这样才有可能是正值
                    int tmp = imax;
                    imax = imin;
                    imin = tmp;
                }
                imax = Math.max(nums[i],imax * nums[i]);
                //应该取最小的,这样如果是负的  那么之后乘负的将会成为最大的正的
                imin = Math.min(nums[i],imin * nums[i]);

                max = Math.max(max,imax);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
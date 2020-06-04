//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回
// 0。 
//
// 示例: 
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
// 
//
// 进阶: 
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// Related Topics 数组 双指针 二分查找

package leetcode.editor.cn;
//Java：209:长度最小的子数组 2020/06/01
public class MinimumSizeSubarraySum{
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        //TO TEST
        solution.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //滑动窗口
        public int minSubArrayLen(int s, int[] nums) {
            int count = 0,index = 0;
            //初始化窗口

            int ans = Integer.MAX_VALUE;
            int i = 0;
            while (index < nums.length) {
                count = count + nums[index ++];
                //缩小窗口
                while (count >= s && i < nums.length) {
                    ans = Math.min(ans,index - i);
                    count = count - nums[i];
                    i ++;
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
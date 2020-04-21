//给你一个整数数组 nums 和一个整数 k。 
//
// 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。 
//
// 请返回这个数组中「优美子数组」的数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,1,1], k = 3
//输出：2
//解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,6], k = 1
//输出：0
//解释：数列中不包含任何奇数，所以不存在优美子数组。
// 
//
// 示例 3： 
//
// 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10^5 
// 1 <= k <= nums.length 
// 
// Related Topics 双指针

package leetcode.editor.cn;
//Java：1248:统计「优美子数组」滑动窗口 2020/04/21
public class CountNumberOfNiceSubarrays{
    public static void main(String[] args) {
        Solution solution = new CountNumberOfNiceSubarrays().new Solution();
        //TO TEST
        solution.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2,1},2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numberOfSubarrays(int[] nums, int k) {
            int count = 0,preOdd = -1,ans = 0;
            for (int i = 0;i < nums.length;i ++) {
                //奇数
                if (nums[i] % 2 == 1) {
                    if (preOdd == -1) {
                        preOdd = i;
                    }
                    count ++;
                }
                //窗口满足条件
                if (count >= k) {
                    ans ++;
                    if (count > k) {
                        count --;
                        //因为新进来一个奇数  所以要出去一个奇数
                        preOdd ++;
                        while (preOdd < nums.length && nums[preOdd] % 2 == 0) {
                            preOdd ++;
                        }
                    }
                    //因为要求尽可能多的情况  所以应该往左滑动窗口扩大窗口 囊括偶数
                    for (int j = preOdd - 1;j >= 0;j --) {
                        if (nums[j] % 2 == 1) {
                            break;
                        }
                        ans ++;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
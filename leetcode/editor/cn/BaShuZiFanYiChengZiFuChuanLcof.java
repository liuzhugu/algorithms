//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Java：面试题46:把数字翻译成字符串 动态规划 2020/04/23
public class BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        //TO TEST
        solution.translateNum(506);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            List<Integer> list = new ArrayList<>();
            while (num != 0) {
                //取最后一位数
                list.add(num % 10);
                num = num / 10;
            }
            Collections.reverse(list);
            int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();
            int[] dp = new int[nums.length + 1];
            dp[0] = 1;
            for (int i = 1;i <= nums.length;i ++) {
                //单独一个字符
                dp[i] = dp[i] + dp[i - 1];
                //和前一个数字一起组成一个两位数
                if (i > 1 && nums[i - 2] != 0) {
                    int sum = nums[i - 2] * 10 + nums[i - 1];
                    if (sum <= 25) {
                        dp[i] = dp[i] + dp[i - 2];
                    }
                }
            }
            return dp[nums.length];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
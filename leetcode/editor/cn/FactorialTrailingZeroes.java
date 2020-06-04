//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学

package leetcode.editor.cn;
//Java：172:阶乘后的零 2020/05/29
public class FactorialTrailingZeroes{
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //比如 125之内 有1个5的有 125/5 个   有两个5为因数的由125/25个  有三个5为因数的由125/125个
        public int trailingZeroes(int n) {
            int zeroCount = 0;
            long currentMultiple = 5;
            while (n >= currentMultiple) {
                zeroCount += (n / currentMultiple);
                currentMultiple *= 5;
            }
            return zeroCount;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
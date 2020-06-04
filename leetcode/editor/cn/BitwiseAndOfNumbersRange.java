//给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。 
//
// 示例 1: 
//
// 输入: [5,7]
//输出: 4 
//
// 示例 2: 
//
// 输入: [0,1]
//输出: 0 
// Related Topics 位运算

package leetcode.editor.cn;
//Java：201:数字范围按位与  求公共前缀 2020/05/30
public class BitwiseAndOfNumbersRange{
    public static void main(String[] args) {
        Solution solution = new BitwiseAndOfNumbersRange().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //m > n
        //如果 m 和 n同位  那么公共前缀为两者之前
        //如果两者不位  那么m肯定比n多位  那么连 n 都应该去掉
        public int rangeBitwiseAnd(int m, int n) {
            while (n > m) {
                n = n & (n - 1);
            }
            return n;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
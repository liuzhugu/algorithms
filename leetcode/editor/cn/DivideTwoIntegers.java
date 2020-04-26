//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找

package leetcode.editor.cn;
//Java：29:两数相除 2020/04/26
public class DivideTwoIntegers{
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        //TO TEST
        solution.divide(1,1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //28 = 16 + 8 + 4 = (4 + 2 + 1) * 4
        //因此28减去16 那么与4的商应该对应加上4 再减去8 商再加上2 一次类推
        public int divide(int dividend, int divisor) {
            //符号
            boolean s = (dividend ^ divisor) >= 0;

            //转换为正数
            long d1 = Long.valueOf(dividend);
            long d2 = Long.valueOf(divisor);
            d1 = d1 > 0 ? d1 : - d1;
            d2 = d2 > 0 ? d2 : - d2;

            if (d1 < d1) return 0;

            long cmp = d2;
            Long ans = 0L,partial_sum = 1L;
            //两倍膨胀
            while ((cmp << 1) < d1) {
                cmp = cmp << 1;
                partial_sum = partial_sum << 1;
            }
            //1/2缩减
            while (d1 >= d2) {
                //每个 cmp = partial_sum * d2
                //因此除数减去cmp 那么商应该加上partial_sum
                d1 = d1 - cmp;
                ans =  ans + partial_sum;
                //如果d1无法减去cmp  那么cmp应该缩小
                while (cmp > d1) {
                    cmp = cmp >> 1;
                    partial_sum = partial_sum >> 1;
                }
            }
            if (s) {
                return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : ans.intValue();
            } else {
                return  - ans.intValue();
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}
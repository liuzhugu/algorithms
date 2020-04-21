//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归

package leetcode.editor.cn;
//Java：面试题16:数值的整数次方  二分法  2020/04/21
public class ShuZhiDeZhengShuCiFangLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        //TO TEST
        solution.myPow(2,-2147483648);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //一个个乘太麻烦   直接平方  那么就从n变成了log n
        public double myPow(double x, int n) {
            //因为不是所有int都有对应的正数的
            long b = n;
            if (b < 0) {
                b = - b;
            }
            if (n >= 0) {
                return recursive(x,b);
            } else {
                return 1 / recursive(x,b);
            }

        }

        private double recursive(double x,long n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            double ans = recursive(x,n / 2);
            if (n % 2 == 0) {
                return ans * ans;
            } else {
                return ans * ans * x;
            }
        }

        //超时
//        public double myPow(double x, int n) {
//            if (x == 1) {
//                return 1;
//            }
//            //不是所有的int都有其绝对值
//            int abs = 0;
//            if (n == Integer.MIN_VALUE) {
//                 abs = Integer.MAX_VALUE;
//            } else {
//                 abs = Math.abs(n + 1);
//            }
//            double base = x;
//            x = 1;
//            for (int i = 0;i < abs;i ++) {
//                x = x * base;
//            }
//            if (n >= 0) {
//                return x;
//            } else {
//                return 1 / x;
//            }
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
//

package leetcode.editor.cn;
//Java：面试题64:求1+2+…+n  2020/04/23
public class Qiu12nLcof{
    public static void main(String[] args) {
        Solution solution = new Qiu12nLcof().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int res = 0;
        public int sumNums(int n) {
            //不用用if 那么可以用短路来模拟判断  如果前一项为真才会计算后一项
            boolean x = n > 1 && sumNums(n - 1) > 0;
            res += n;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
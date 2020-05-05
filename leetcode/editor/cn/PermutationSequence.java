//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法

package leetcode.editor.cn;
//Java：60:第k个排列
public class PermutationSequence{
    public static void main(String[] args) {
        Solution solution = new PermutationSequence().new Solution();
        //TO TEST
        String s = "123456789";
        System.out.println(s.substring(0,4) +  s.substring(4 + 1,s.length()));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] fac = {0,1,2,6,24,120,720,5040,40320,362880,3628800};
        public String getPermutation(int n, int k) {
            StringBuilder res = new StringBuilder();
            String s = new String("123456789").substring(0, n);
            -- k;
            while (k > 0) {
                //有多少个(n - 1)! 那么就有从小到大多少个数字被放到第一位
                int i = k / fac[n - 1];
                //如果没有(n - 1)!  那么顺序取第一位
                res.append(s.charAt(i));
                s = s.substring(0,i) +  s.substring(i + 1,s.length());
                k %= fac[n - 1];
                -- n;
            }
            return res + s;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
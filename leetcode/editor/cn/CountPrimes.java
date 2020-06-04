//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学

package leetcode.editor.cn;
//Java：204:计数质数 2020/05/31
public class CountPrimes{
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            boolean[] notPrime = new boolean[n];
            for (int i = 2;i < n;i ++) {
                if (! notPrime[i]) {
                    for (int j = 2 * i;j < n;j = j + i) {
                        notPrime[j] = true;
                    }
                }
            }
            int count = 0;
            for (int i = 2;i < n;i ++) {
                if (! notPrime[i]) {
                    count ++;
                }
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
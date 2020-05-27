//给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。 
//
// 
//
// 示例： 
//
// 输入：A = [4,5,0,-2,-3,1], K = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 K = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// -10000 <= A[i] <= 10000 
// 2 <= K <= 10000 
// 
// Related Topics 数组 哈希表

package leetcode.editor.cn;
//Java：974:和可被 K 整除的子数组 前缀和 2020/05/27
public class SubarraySumsDivisibleByK{
    public static void main(String[] args) {
        Solution solution = new SubarraySumsDivisibleByK().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //同余理论   两个前缀和与k的模相同  那么说明他们之间的数组之和能整除k
        public int subarraysDivByK(int[] A, int K) {
            int N = A.length, sum = 0, ans = 0;
            int[] map = new int[K];
            map[0] = 1;
            //一次遍历
            for (int i = 1; i <= N; i++) {
                sum = sum + A[i-1];
                //只要前缀和模为key的任意下标到i的子数组都能整除K
                //因为sum % K 余数可能为负  所以把其变成整数
                int key = (sum % K + K) % K;
                ans += map[key];
                map[key]++;
            }
            return ans;
        }


        //n * n  超时
//        public int subarraysDivByK(int[] A, int K) {
//            int m = A.length;
//            int[] sum = new int[m + 1];
//            for (int i = 1;i <= m;i ++) {
//                sum[i] = sum[i - 1] + A[i - 1];
//            }
//            int count = 0;
//            for (int i = 0;i < m;i ++) {
//                for (int j = i + 1;j <= m;j ++) {
//                    int num = sum[j] - sum[i];
//                    if (num % K == 0) {
//                        count ++;
//                    }
//                }
//            }
//            return count;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划

package leetcode.editor.cn;
//Java：85:最大矩形   动态规划  2020/04/19
public class MaximalRectangle{
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //最多  动态规划
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int m = matrix.length,n = matrix[0].length;
            int[][] dp = new int[m + 1][n + 1];
            //初始化

            //递推公式
            //返回结果
            return dp[m][n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
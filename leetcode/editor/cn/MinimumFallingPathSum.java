//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：下面是两条和最小的下降路径，用加粗标注：
//[[2,1,3],      [[2,1,3],
// [6,5,4],       [6,5,4],
// [7,8,9]]       [7,8,9]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：下面是一条和最小的下降路径，用加粗标注：
//[[-19,57],
// [-40,-5]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[-48]]
//输出：-48
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 动态规划 
// 👍 79 👎 0

package leetcode.editor.cn;
//Java：931:下降路径最小和
public class MinimumFallingPathSum{
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //从第二行开始  到每个元素的路径的最小和 等于上一层能抵达该点的元素中其路劲和最小的 + 该元素的的值
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] pathMin = new int[n][n];
            for (int i = 0;i < n;i ++) {
                for (int j = 0;j < n;j ++) {
                    pathMin[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0;i < n;i ++) {
                for (int j = 0;j < n;j ++) {
                    if (i > 0) {
                        //左上角
                        if (j > 0) {
                            pathMin[i][j] = Math.min(pathMin[i - 1][j - 1],pathMin[i][j]);
                        }
                        //正上方
                        pathMin[i][j] = Math.min(pathMin[i - 1][j],pathMin[i][j]);
                        //右上方
                        if (j < n - 1) {
                            pathMin[i][j] = Math.min(pathMin[i - 1][j + 1],pathMin[i][j]);
                        }
                        //得到最小路径之后  加上该元素的值
                        pathMin[i][j] = pathMin[i][j] + matrix[i][j];
                    } else {
                        //第一行因为没有前一个节点  因此直接计算
                        pathMin[i][j] = matrix[i][j];
                    }
                }
            }
            //从最后一行中获取最小的
            int result = Integer.MAX_VALUE;
            for (int i = 0;i < n;i ++) {
                result = Math.min(result,pathMin[n - 1][i]);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
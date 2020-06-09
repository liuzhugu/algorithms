//给你一个 2D 矩阵 matrix，请计算出从左上角 (row1, col1) 到右下角 (row2, col2) 组成的矩形中所有元素的和。 
//
// 
//上述粉色矩形框内的，该矩形由左上角 (row1, col1) = (2, 1) 和右下角 (row2, col2) = (4, 3) 确定。其中，所包括的元
//素总和 sum = 8。 
//
// 示例： 
//
// 给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//update(3, 2, 2)
//sumRegion(2, 1, 4, 3) -> 10
// 
//
// 
//
// 注意: 
//
// 
// 矩阵 matrix 的值只能通过 update 函数来进行修改 
// 你可以默认 update 函数和 sumRegion 函数的调用次数是均匀分布的 
// 你可以默认 row1 ≤ row2，col1 ≤ col2 
// 
//
// 
// Related Topics 树状数组 线段树

package leetcode.editor.cn;
//Java：308:二维区域和检索 - 可变 前缀和 2020/06/08
public class RangeSumQuery2dMutable{
    public static void main(String[] args) {
        //NumMatrix solution = new RangeSumQuery2dMutable().new NumMatrix();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        private int[][] matrix;
        //从右到左序列总和
        private int[][] sum;
        int m,n;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            this.m = matrix.length;
            if (matrix != null && matrix.length != 0) {
                this.n = matrix[0].length;
            } else {
                n = 0;
            }
            sum = new int[m][n + 1];
            for (int i = 0;i < m;i ++) {
                for (int j = n - 1;j >= 0;j --) {
                    sum[i][j] = sum[i][j + 1] + matrix[i][j];
                }
            }
        }

        public void update(int row, int col, int val) {
            int change = val - matrix[row][col];
            matrix[row][col] = val;
            //从该点开始往左  全都要变化
            for (int i = col;i >= 0;i --) {
                sum[row][i] = sum[row][i] + change;
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1;i <= row2;i ++) {
                ans = ans + (sum[i][col1] - sum[i][col2 + 1]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
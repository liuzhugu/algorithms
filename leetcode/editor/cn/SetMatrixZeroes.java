//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2: 
//
// 输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//] 
//
// 进阶: 
//
// 
// 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个常数空间的解决方案吗？ 
// 
// Related Topics 数组

package leetcode.editor.cn;
//Java：73:矩阵置零 2020/05/05
public class SetMatrixZeroes{
    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            int m = matrix.length,n = matrix[0].length;
            //标记第一行是否有0
            boolean col0Flag = false;
            //从左上到右下开始标记
            for (int i = 0;i < m;i ++) {
                //标记第一行是否有0
                if (matrix[i][0] == 0) {
                    col0Flag = true;
                }
                for (int j = 1;j < n;j ++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            //从右下到左上开始处理  因为最上面哪行和最右边这一列作为标记位  应该最后处理
            //否则会污染结果
            for (int i = m - 1;i >= 0;i --) {
                for (int j = n - 1;j >= 1;j --) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
                //最后处理第一位 否则第一行和第一列会互相影响
                if (col0Flag) {
                    matrix[i][0] = 0;
                }
            }

        }

//       public void setZeroes(int[][] matrix) {
//            if (matrix == null || matrix.length == 0) {
//                return;
//            }
//            int m = matrix.length,n = matrix[0].length;
//            boolean[] x = new boolean[m];
//            boolean[] y = new boolean[n];
//            for (int i = 0;i < m;i ++) {
//                for (int j = 0;j < n;j ++) {
//                    if (matrix[i][j] == 0) {
//                        x[i] = true;
//                        y[j] = true;
//                    }
//                }
//            }
//            for (int i = 0;i < m;i ++) {
//                for (int j = 0;j < n;j ++) {
//                    if (x[i]) {
//                        matrix[i][j] = 0;
//                    }
//                    if (y[j]) {
//                        matrix[i][j] = 0;
//                    }
//                }
//            }
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
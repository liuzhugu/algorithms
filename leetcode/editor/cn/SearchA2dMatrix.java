//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找

package leetcode.editor.cn;
//Java：74:搜索二维矩阵 2020/05/05
public class SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        //TO TEST
        solution.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            //从右上开始找  如果比他大 那么在下边  如果比它小  在左边
            int m = matrix.length,n = matrix[0].length,i = 0,j = n - 1;
            while (i < m && j >= 0) {
                if (target == matrix[i][j]) {
                    return true;
                } else if (target > matrix[i][j]) {
                    i ++;
                } else {
                    j --;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
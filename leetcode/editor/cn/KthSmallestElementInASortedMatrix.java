//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例： 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找

package leetcode.editor.cn;
//Java：378:有序矩阵中第K小的元素
public class KthSmallestElementInASortedMatrix{
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length - 1;
            int left = matrix[0][0],right = matrix[n][n];
            while (left < right) {
                int mid = (left + right) / 2;
                int count = countNotMoreThanMid(matrix,mid,n);
                //第k个数比mid大
                if (count < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
        private int countNotMoreThanMid(int[][] matrix,int mid,int n) {
            int count = 0;
            int x = 0,y = n;
            //从底部开始往右统计  如果大于mid那么往上
            while (x <= n && y >= 0) {
                //在y之前的也小于mid
                if (matrix[y][x] <= mid) {
                    count += y + 1;
                    x ++;
                }
                //往上
                else {
                    y --;
                }
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
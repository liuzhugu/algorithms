//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：面试题 01.08:零矩阵 2020/04/24
public class ZeroMatrixLcci{
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            Set<Integer> xSet = new HashSet<>();
            Set<Integer> ySet = new HashSet<>();
            int m = matrix.length,n = matrix[0].length;
            for (int i = 0;i < m;i ++) {
                for (int j = 0;j < n;j ++) {
                    if (matrix[i][j] == 0) {
                        xSet.add(i);
                        ySet.add(j);
                    }
                }
            }
            for (int i = 0;i < m;i ++) {
                for (int j = 0; j < n; j++) {
                    if (xSet.contains(i)) {
                        matrix[i][j] = 0;
                    }
                    if (ySet.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
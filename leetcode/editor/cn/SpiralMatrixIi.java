//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组

package leetcode.editor.cn;
//Java：59:螺旋矩阵 II
public class SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        //TO TEST
        solution.generateMatrix(3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            if (n <= 0) {
                return new int[][]{};
            }
            int[][] ans = new int[n][n];
            int left = 0,top = 0,right = n - 1,buttom = n - 1;
            int index = 1;
            while (left <= right && top <= buttom) {
                //左
                for (int i = top;i < buttom;i ++) {
                    ans[left][i] = index ++;
                }
                //上
                for (int i = left;i < right;i ++) {
                    ans[i][buttom] = index ++;
                }
                //右
                for (int i = buttom;i > top;i --) {
                    ans[right][i] = index ++;
                }
                //下
                for (int i = right;i > left;i --) {
                    ans[i][top] = index ++;
                }
                if (left == right && top == buttom) {
                    ans[left][top] = index;
                }
                left ++;
                right --;
                top ++;
                buttom --;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
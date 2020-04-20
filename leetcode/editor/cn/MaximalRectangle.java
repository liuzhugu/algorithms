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

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

//Java：85:最大矩形   单调栈  2020/04/19
public class MaximalRectangle{
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        //TO TEST
        String str = "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]";
        System.out.println(str.replace("\"","'").replace("[","{").replace("]","}"));
        solution.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}
        );
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int m = matrix.length, n = matrix[0].length;
            //从上边到当前格连续为1的长度 像是柱状图
            //然后下边开始横着切 就得到以该边为底的柱状图所能围成的矩形的最大面积
            int[][] heights = new int[m][n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (matrix[i][j] == '0') {
                        heights[i][j] = 0;
                    } else {
                        //因为要取整个数组 只能例如matrix[i]  是横着取
                        //那么计算柱状图长度必须纵着算 这样才能切
                        if (i > 0) {
                            heights[i][j] = heights[i - 1][j] + 1;
                        } else {
                            heights[i][j] = 1;
                        }
                    }
                }
            }
            int ans = 0;
            //横着切  算柱状图围成的最大面积 即是以该行为底边的所围成的矩形的最大面积
            for (int i = m - 1; i >= 0; i--) {
                ans = Math.max(ans, getMaxArea(heights[i]));
            }
            return ans;
        }

        //柱状图围成的矩形的最大面积
        private int getMaxArea(int[] nums) {
            //单调递增栈  找山峰
            Stack<Integer> stack = new Stack<>();
            int ans = 0;
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            //哨兵 便于使用stack.peek()
            list.add(0, 0);
            //因为0小于等于栈中所有元素  因此逼得程序清空栈来计算
            list.add(0);
            for (int i = 0; i < list.size(); i++) {
                while (!stack.empty() && list.get(stack.peek()) > list.get(i)) {
                    //计算面积
                    int cur = stack.pop();
                    int left = stack.peek() + 1;
                    int right = i - 1;
                    ans = Math.max(ans, (right - left + 1) * list.get(cur));
                }
                stack.add(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
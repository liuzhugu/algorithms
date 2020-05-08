//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

//Java：221:最大正方形 2020/05/07
public class MaximalSquare{
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        //TO TEST
        //System.out.println(LeetCodeTest.strDeal("[[\"0\",\"0\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"0\"],[\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"0\"]]"));
        System.out.println(solution.maximalSquare(new char[][]{{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}}
        ));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int m = matrix.length,n = matrix[0].length;
            int[][] high = new int[m][n];
            for (int j = 0;j < n;j ++) {
                for (int i = m - 1;i >= 0;i --) {
                    if (matrix[i][j] == '0') {
                        high[i][j] = 0;
                    } else {
                        if (i < m - 1) {
                            high[i][j] = high[i + 1][j] + 1;
                        } else {
                            high[i][j] = 1;
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 0;i < m;i ++) {
                ans = Math.max(ans,getMaxSquare(high[i]));
            }
            return ans;
        }
        //围成的正方形  要求山峰 因此用单调递增栈
        private int getMaxSquare(int[] nums) {
            int max = Integer.MIN_VALUE;
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            //为了让第一个也能围成
            list.add(0,0);
            //为了清空栈
            list.add(0);
            Stack<Integer> stack = new Stack<>();
            //哨兵
            for (int i = 0;i < list.size();i ++) {
                int num = list.get(i);
                while (! stack.isEmpty() && num < list.get(stack.peek())) {
                    int hight = list.get(stack.pop());
                    int left = stack.peek() + 1;
                    int right = i - 1;
                    int width = (right - left + 1);
                    width = Math.min(width,hight);
                    max = Math.max(max,width * width);
                }
                stack.add(i);
            }
            return max;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
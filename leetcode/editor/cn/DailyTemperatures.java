//根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表

package leetcode.editor.cn;

import java.util.Stack;

//Java：739:每日温度  单调栈 2020/04/20
public class DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //后面比前面大  那么应该是单调递减栈
        public int[] dailyTemperatures(int[] T) {
            Stack<Integer> stack = new Stack<>();
            int[] ans = new int[T.length];
            for (int i = 0;i < T.length;i ++) {
                while (! stack.empty() && T[stack.peek()] < T[i]) {
                    int index = stack.peek();
                    ans[index] = i - index;
                    stack.pop();
                }
                stack.add(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
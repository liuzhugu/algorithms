//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//Java：84:柱状图中最大的矩形  单调栈 2020/04/19
public class LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        //TO TEST
        System.out.println(solution.largestRectangleArea(new int[]{1,6,8,9,7}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //要计算最大矩形  那么需要从每一个山峰往两边扩散来划定矩形
        // 而单调递增栈每次出栈都意味着出现一个山峰  那么此时就可以计算该山峰划定的矩形的最大面积了
        public int largestRectangleArea(int[] heights) {
            //在单调递增栈中  每两个数对应回原来数组  中间的数都比他们大
            //因为围成的矩形面积取决于宽 乘 最小高度  因此单调栈中的数就是该范围的最小值
            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            List<Integer> list = Arrays.stream(heights).boxed().collect(Collectors.toList());
            //哨兵
            list.add(0,0);
            //在结尾加上0  小于栈的所有元素  因此逼得程序清空栈来计算
            list.add(0);
            for (int i = 0;i < list.size();i ++) {
                while (! stack.empty() && list.get(stack.peek()) > list.get(i)) {
                    //求面积

                    //因为栈是单调递增的 那么每次弹出的值都要小于之前弹出的值
                    // 因此就是要计算的矩形的最低边
                    int current = stack.pop();
                    //矩形左右  范围是栈顶元素和待入栈之间
                    int left = stack.peek() + 1;
                    int right = i - 1;
                    ans = Math.max(ans,(right - left + 1) * list.get(current));
                }
                stack.add(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
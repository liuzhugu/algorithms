//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：239:滑动窗口最大值 2020/05/08
public class SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        //TO TEST
        solution.maxSlidingWindow(new int[]{3,3,1,2,0,5},3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < k) {
                return new int[]{};
            }
            int[] ans = new int[nums.length - k + 1];
            //递减栈
            Deque<Integer> deque = new LinkedList<>();
            int index = 0;
            for (int i = 0;i < nums.length;i ++) {
                //不在窗口内的应该出栈
                if (! deque.isEmpty() && deque.getFirst() < i - k + 1) {
                    deque.removeFirst();
                }
                //维持递减栈
                while (! deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.add(i);
                if (i >= k - 1) {
                    ans[index ++] = nums[deque.getFirst()];
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
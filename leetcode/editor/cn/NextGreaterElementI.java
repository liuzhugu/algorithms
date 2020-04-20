//给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其
//大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于num1中的数字2，第二个数组中的下一个较大数字是3。
//    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
// 
//
// 注意: 
//
// 
// nums1和nums2中所有元素是唯一的。 
// nums1和nums2 的数组大小都不超过1000。 
// 
// Related Topics 栈

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Java：496:下一个更大元素 I 单调栈 2020/04/20
public class NextGreaterElementI{
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //找更大  那么是单调递减栈
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return new int[]{};
            }
            Map<Integer,Integer> map = new HashMap<>();
            int m = nums1.length,n = nums2.length;
            int[] ans = new int[m];
            //初始化
            for (int i = 0;i < m;i ++) {
                ans[i] = - 1;
            }
            for (int i = 0;i < m;i ++) {
                map.put(nums1[i],i);
            }
            //单调递减栈
            Stack<Integer> stack = new Stack<>();
            for (int i = 0;i < n;i ++) {
                while (! stack.empty() && nums2[stack.peek()] < nums2[i]) {
                    int num = nums2[stack.peek()];
                    if (map.containsKey(num)) {
                        ans[map.get(num)] = nums2[i];
                    }
                    stack.pop();
                }
                stack.add(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
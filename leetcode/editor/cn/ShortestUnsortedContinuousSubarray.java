//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

//Java：581:最短无序连续子数组 2020/05/16
public class ShortestUnsortedContinuousSubarray{
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        //TO TEST
        solution.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] tmp = new int[nums.length];
            for (int i = 0;i < nums.length;i ++) {
                tmp[i] = nums[i];
            }
            Arrays.sort(tmp);
            int left = 0;
            while (left < nums.length && tmp[left] == nums[left]) {
                left ++;
            }
            int right = nums.length - 1;
            while (right > left && tmp[right] == nums[right]) {
                right --;
            }
            if (left == nums.length || left == right) {
                return 0;
            } else {
                return right - left + 1;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//Java：16:最接近的三数之和 2020/04/24
public class ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        //TO TEST
        solution.threeSumClosest(new int[]{-3,-2,-5,3,-4},-1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return 0;
            }
            int ans = 1000000;
            Arrays.sort(nums);
            for (int i = 0;i < nums.length - 2;i ++) {
                int left = i + 1,right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == target) {
                        return target;
                    }
                    if (Math.abs(sum - target) < Math.abs(ans - target)) {
                        ans = sum;
                    }
                    if (sum > target) {
                        right --;
                    } else {
                        left ++;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
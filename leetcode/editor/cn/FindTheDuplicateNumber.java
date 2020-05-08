//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找

package leetcode.editor.cn;
//Java：287:寻找重复数 2020/05/08
public class FindTheDuplicateNumber{
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        //TO TEST
        solution.findDuplicate(new int[]{1,3,2,2,4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            int n = nums.length - 1;
            //二分查找  因为数组不有序 因此遍历统计
            int left = 1,right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int count = 0;
                for (int i = 0;i <= n;i ++) {
                    int num = nums[i];
                    if (num <= mid) {
                        count ++;
                    }
                }
                if (count > mid) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
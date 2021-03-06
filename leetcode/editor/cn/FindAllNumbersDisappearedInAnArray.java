//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：448:找到所有数组中消失的数字
public class FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //不能额外空间 那么只能原地
        public List<Integer> findDisappearedNumbers(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            for (int i = 0;i < nums.length;i ++) {
                while (nums[i] != (i + 1)) {
                    //防止出现循环
                    if (nums[i] == nums[nums[i] - 1]) {
                        break;
                    }
                    int tmp = nums[i];
                    nums[i] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0;i < nums.length;i ++) {
                if (nums[i] != (i + 1)) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
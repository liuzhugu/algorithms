//给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。 
//
// 示例： 
//
// 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
//输出: ["2", "4->49", "51->74", "76->99"]
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：163:缺失的区间 2020/05/26
public class MissingRanges{
    public static void main(String[] args) {
        Solution solution = new MissingRanges().new Solution();
        //TO TEST
        solution.findMissingRanges(new int[]{-2147483648,-2147483648,0,2147483647,2147483647},
                -2147483648 ,2147483647);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<long[]> ranges = new ArrayList<>();
            long left = lower,right = upper;
            for (int i = 0;i < nums.length;i ++) {
                long num = nums[i];
                if (num == left) {
                    left ++;
                } else {
                    //切分
                    if (left <= num - 1) {
                        ranges.add(new long[]{left,num - 1});
                    }
                    left = num + 1;
                }
            }
            if (left <= right) {
                ranges.add(new long[]{left,right});
            }
            List<String> ans = new ArrayList<>();
            for (long[] range : ranges) {
                if (range[0] == range[1]) {
                    ans.add("" + range[0]);
                } else {
                    ans.add(range[0] + "->" + range[1]);
                }
            }
            return ans;
        }
//        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
//            List<String> ans = new ArrayList<>();
//            //扩充范围 pre是不会越界的
//            long pre = (long)lower - 1;
//            for (int i = 0; i < nums.length; i++) {
//                int num = nums[i];
//                if (num - pre == 2) {
//                    ans.add(String.valueOf(pre + 1));
//                } else if (num - pre > 2) {
//                    ans.add((pre + 1) + "->" + (num - 1));
//                }
//                pre = num;
//            }
//            if (upper - pre == 1) {
//                ans.add(String.valueOf(upper));
//            } else if (upper - pre > 1) {
//                ans.add((pre + 1) + "->" + (upper));
//            }
//            return ans;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: 210 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: 9534330 
//
// 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
// Related Topics 排序

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Java：179:最大数 2020/05/30
public class LargestNumber{
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        //TO TEST
        solution.largestNumber(new int[]{});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return "";
            }
            List<String> list = new ArrayList<>();
            for (int i = 0;i < nums.length;i ++) {
                list.add(nums[i] + "");
            }
            //排序
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String first = o1 + o2;
                    String second = o2 + o1;
                    //从大到小
                    return second.compareTo(first);
                }
            });
            //避免全是0
            if (list.get(0).equals("0")) {
                return "0";
            }
            StringBuilder stringBuilder = new StringBuilder();
            //开始拼接
            for (String num : list) {
                stringBuilder.append(num);
            }
            return stringBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

package leetcode.editor.cn;
//Java：66:加一
public class PlusOne{
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        //TO TEST
        solution.plusOne(new int[]{1,2,3});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 0;
            for (int i = digits.length - 1;i >= 0;i --) {
                int sum = 0;
                if (i == digits.length - 1) {
                    sum = digits[i] + 1;
                } else {
                    sum = digits[i] + carry;
                }
                carry = sum / 10;
                digits[i] = sum % 10;
                if (carry == 0) {
                    break;
                }
            }
            //进位未处理完
            if (carry != 0) {
                int[] tmp = new int[digits.length + 1];
                tmp[0] = carry;
                for (int i = 0;i < digits.length;i ++) {
                    tmp[i + 1] = digits[i];
                }
                digits = tmp;
            }
            return digits;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
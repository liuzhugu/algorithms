//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串

package leetcode.editor.cn;
//Java：43:字符串相乘  2020/05/03
public class MultiplyStrings{
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        //TO TEST
        solution.multiply("123456789",
                "987654321");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1 == null || num2 == null) {
                return "";
            }
            //让num1更长
            if (num2.length() > num1.length()) {
                String tmp = num1;
                num1 = num2;
                num2 = tmp;
            }
            num1 = new StringBuilder(num1).reverse().toString();
            num2 = new StringBuilder(num2).reverse().toString();
            StringBuilder stringBuilder = new StringBuilder();
            String ans = "0";
            for (int i = 0;i < num2.length();i ++) {
                if (i > 0) {
                    stringBuilder.append("0");
                }
                String tmp = multiply(num1,num2.charAt(i),stringBuilder.toString());
                ans = add(ans,tmp);
            }
            StringBuilder zero = new StringBuilder();
            for (int i = 0;i < ans.length();i ++) {
                zero.append('0');
            }
            String str = new StringBuilder(ans).reverse().toString();
            if (str.equals(zero.toString())) {
                return "0";
            } else {
                return str;
            }
        }
        private String multiply(String str,char c,String start) {
            char[] chars = str.toCharArray();
            int num = c - '0';
            int carry = 0;
            StringBuilder stringBuilder = new StringBuilder(start);
            for (int i = 0;i < str.length();i ++) {
                int sum = (chars[i] - '0') * num;
                sum = sum + carry;
                stringBuilder.append(sum % 10);
                carry = sum / 10;
            }
            if (carry != 0) {
                stringBuilder.append(carry);
            }
            return stringBuilder.toString();
        }
        private String add(String first,String second) {
            char[] chars1 = first.toCharArray();
            char[] chars2 = second.toCharArray();
            int carry = 0;
            int m = first.length(),n = second.length();
            int index = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (index < m && index < n) {
                int sum = (chars1[index] - '0') + (chars2[index] - '0');
                sum = sum + carry;
                stringBuilder.append(sum % 10);
                carry = sum / 10;
                index ++;
            }
            if (index == m) {
                while (index < n) {
                    int sum = chars2[index] - '0';
                    sum = sum + carry;
                    stringBuilder.append(sum % 10);
                    carry = sum / 10;
                    index ++;
                }
            }
            if (index == n) {
                while (index < m) {
                    int sum = chars1[index] - '0';
                    sum = sum + carry;
                    stringBuilder.append(sum % 10);
                    carry = sum / 10;
                    index ++;
                }
            }
            if (carry != 0) {
                stringBuilder.append(carry);
            }
            return stringBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
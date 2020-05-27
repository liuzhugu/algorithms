//给定两个整数，分别表示分数的分子 num 和分母 den，以字符串形式返回小数。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 示例 1: 
//
// 输入: num = 1, den = 2
//输出: "0.5"
// 
//
// 示例 2: 
//
// 输入: num = 2, den = 1
//输出: "2" 
//
// 示例 3: 
//
// 输入: num = 2, den = 3
//输出: "0.(6)"
// 
// Related Topics 哈希表 数学

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Java：166:分数到小数 2020/05/26
public class FractionToRecurringDecimal{
    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();
        //TO TEST
        solution.fractionToDecimal(12,101);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            //负数变整数可能溢出
            long num = numerator;
            long den = denominator;
            String sign = "";
            //确定符号
            if (num > 0 && den < 0 || num < 0 && den > 0) {
                sign = "-";
            }
            num = Math.abs(num);
            den = Math.abs(den);
            StringBuilder integerStr = new StringBuilder(sign);
            //先找整数部分
            long quotient = num / den;
            integerStr.append(quotient);
            if (quotient * den == num) {
                return integerStr.toString();
            }
            //小数点
            integerStr.append(".");
            //处理小数部分
            StringBuilder decimalStr = new StringBuilder();
            boolean circle = false;
            int repeatIndex = -1,index = 0;
            Map<Long,Integer> map = new HashMap<>();
            long remainder = num % den;
            //余数相同时 说明出现循环
            while (remainder != 0) {
                remainder = remainder * 10;
                if (map.containsKey(remainder)) {
                    circle = true;
                    repeatIndex = map.get(remainder);
                    break;
                }
                map.put(remainder,index);
                quotient = remainder / den;
                remainder = remainder % den;
                //否则继续求小数
                decimalStr.append(quotient);
                index ++;
            }
            if (circle) {
                char[] chars = decimalStr.toString().toCharArray();
                for (int i = 0;i < chars.length;i ++) {
                    if (i == repeatIndex) {
                        integerStr.append("(").append(chars[i]);
                    } else {
                        integerStr.append(chars[i]);
                    }
                }
                integerStr.append(")");
            } else {
                integerStr.append(decimalStr.toString());
            }
            return integerStr.toString();
        }
        private int gcd(int x,int y) {
            if (y == 0) {
                return x;
            } else {
                return gcd(y,x % y);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
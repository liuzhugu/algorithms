package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/06.
 * 面试题20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、
 * "0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class IsNumber {
    /**
    * 核心: 有效数字的模式只有两种:
    * 1)A[.[B]][e|EC]  比如: +100   -67.0  29.    3.14E5
    * 2).B[e|EC]       比如: .3     .4E6
    * 其中,A、C是整数，B是正整数; [e|EC]表示[eC]或者[EC]
    * 原则: 有A的话,有没有B都可以; 没有A的话, 必须有B
    */

    //查找字符的位置
    private int index = 0;
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        //找到A
        boolean A = scanInteger(s),B = false,C = false;
        //判断B
        if (index < s.length() && s.charAt(index) == '.') {
            //看小数点之后是否是正整数
            index ++;
            B = scanUnsignedInteger(s);
        }
        //判断C
        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')){
            index ++;
            C = scanInteger(s);
            if (C == false) {
                return false;
            }
        }
        //总判断   字符处理完  且A或B至少有一个成立
        return (index == s.length()) && (A || B);
    }

    //找一个整数
    private boolean scanInteger(String s) {
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            index ++;
        }
        return scanUnsignedInteger(s);
    }
    //找一个正整数
    private boolean scanUnsignedInteger(String s) {
        int tmp = index;
        while (index < s.length() && s.charAt(index) - '0' >= 0 && s.charAt(index) - '9' <= 0) {
            index ++;
        }
        //不相等说明在非数字或结尾前没有数字
        return index > tmp;
    }
}

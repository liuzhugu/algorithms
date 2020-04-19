package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2020/03/12.
 * 1071. 字符串的最大公因子
 *  对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 */
public class GcdOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        //两个字符串分别能整除  那么连起来调换位置也仍然能整除
        if (! (str1 + str2).equals(str2 + str1)) {
            return "";
        }
        String str =  str1.substring(0,gcd(str1.length(),str2.length()));
        if (check(str,str1) && check(str,str2)) {
            return str;
        }
        return "";
    }

    private boolean check(String str1,String str2) {
        StringBuilder stringBuilder = new StringBuilder(str1);
        for (int i = str1.length();i < str2.length();i = i + str1.length()) {
            stringBuilder.append(str1);
        }
        return stringBuilder.toString().equals(str2);
    }

    private int gcd(int a,int b) {
        return (b == 0 ? a : gcd(b,a % b));
    }


//    public String gcdOfStrings(String str1, String str2) {
//        for (int length = Math.min(str1.length(),str2.length());length > 0;length --) {
//            if ((str1.length() % length == 0) && (str2.length() % length == 0)) {
//                String x = str1.substring(0,length);
//                if (check(x,str1) && check(x,str2)) {
//                    return x;
//                }
//            }
//         }
//        return "";
//    }
//

}

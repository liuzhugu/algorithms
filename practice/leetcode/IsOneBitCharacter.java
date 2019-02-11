package practice.leetcode;

/**
 * Created by liuzhugu on 2018/5/6.
 * 717. 1比特与2比特字符
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 */
public class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        while (index < bits.length) {
            if (index == bits.length - 1){
                return true;
            }
            if (bits[index] == 0){
                index = index + 1;
            }else {
                index = index + 2;
            }
        }
        return false;
    }

}

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhugu on 2019/07/23.
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class CheckInclusion {

    //滑窗法,在S2中去的子串长度是固定的,只不过需要判断字符组合是否合适而已
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())return false;
        int size = s1.length(),index = 0;
        Map<Character,Integer> chars = new HashMap<>();
        char[] goalChars = s2.toCharArray();
        //因为是缺的,所以是负的,等着右边进来消去
        for (char c : s1.toCharArray()) {
            chars.put(c,chars.getOrDefault(c,0) - 1);
        }
        //确定窗口
        for (int i = 0;i < size;i ++){
            add(chars,goalChars[i]);
        }
        //右边进入窗口是加1,左边出窗口是减1
        while(! chars.isEmpty() && (index + size) < s2.length()) {
            add(chars,goalChars[index + size]);
            sub(chars,goalChars[index]);
            index ++;
        }
        if (chars.isEmpty()) {
            return true;
        }
        return false;
    }
    private void add(Map<Character,Integer> chars,char c) {
        if (chars.get(c) == null) {
            chars.put(c,1);
        }else {
            chars.put(c,chars.get(c) + 1);
        }
        if (chars.get(c) == 0) {
            chars.remove(c);
        }
    }
    private void sub(Map<Character,Integer> chars,char c) {
        if (chars.get(c) == null) {
            chars.put(c,-1);
        }else {
            chars.put(c,chars.get(c) - 1);
        }
        if (chars.get(c) == 0) {
            chars.remove(c);
        }
    }

    //思路正确,但性能不符合要求,因为这是巧妙点的穷举法,但排除的情况还是不够多
    //因为第一个字符串可以任意排列,那么只要第二个字符串的某个子串含有的字母跟第一个字符串完全相等即可
//    public boolean checkInclusion(String s1, String s2) {
//        Map<Character,Integer> chars = new HashMap<>();
//        char[] goalChars = s2.toCharArray();
//        for (char c : s1.toCharArray()) {
//            chars.put(c,chars.getOrDefault(c,0) + 1);
//        }
//        int index = 0;
//        while(index < s2.length()) {
//            int offset = 0;
//            //复制一个来操作
//            Map<Character,Integer> judge = new HashMap<>(chars);
//            while (offset < s1.length() && (offset + index) < s2.length()) {
//                char c = goalChars[offset + index];
//                if (judge.get(c) != null) {
//                    judge.put(c,judge.get(c) - 1);
//                    if (judge.get(c) == 0) {
//                        judge.remove(c);
//                    }
//                    //继续判断下一个字符
//                    offset ++;
//                }
//                else{
//                    //出现不在s1中的字符,因此包含该字符的子串都不符合要求,所以可以直接跳到后面
//                    if (chars.get(c) == null) {
//                        index = index + offset;
//                    }
//                    //如果只有最后一个字符不符合,不重置该值的话,底下true判断就错了
//                    offset = 0;
//                    break;
//                }
//            }
//            if (offset == s1.length()) {
//                return true;
//            }
//            judge = null;
//            index ++;
//        }
//        return false;
//    }
}

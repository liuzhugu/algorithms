package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2019/12/10.
 * 1239. 串联字符串的最大长度
 * 给定一个字符串数组arr，字符串s是将arr某一子序列字符串连接所得的字符串，
 * 如果s中的每一个字符都只出现过一次，那么它就是一个可行解。请返回所有可行解s中最长长度。
 */
public class MaxLength {
    //回溯法
    public int maxLength(List<String> arr) {
        //位图
        int[] map = new int[arr.size()];
        boolean[] check = new boolean[arr.size()];
        int i = 0;
        for (String str : arr) {
            List<Character> chars = new ArrayList<>();
            for (char c : str.toCharArray()) {
                if (chars.contains(c)) {
                    //发现该字符串有重复字符,那么它就不能与其他字符序列相连
                    check[i] = true;
                    break;
                }else {
                    map[i] =  map[i] | 1 << c - 'a';
                    chars.add(c);
                }
            }
            i ++;
        }
        return findMaxLength(arr,map,check,0,0,0,0);
    }
    public int findMaxLength(List<String> arr,int[] map,boolean[] check,long num,int currentLength,int index,int maxLength) {
        if (index == arr.size()) {
            return maxLength;
        }
        String str = arr.get(index);
        int chooseMaxLength = maxLength,notChooseMaxLength = maxLength;
        //选择当前字符串
        //如果没有相同字符
        if (check[index] ==false && (num & map[index]) == 0) {
            int tmp = maxLength > currentLength + str.length() ? maxLength : currentLength + str.length();
            chooseMaxLength = findMaxLength(arr,map,check,num | map[index],tmp,index + 1,tmp);
        }
        //不选择当前字符串
        notChooseMaxLength = findMaxLength(arr,map,check,num,currentLength,index + 1,maxLength);
        return chooseMaxLength > notChooseMaxLength ? chooseMaxLength : notChooseMaxLength;
    }
}

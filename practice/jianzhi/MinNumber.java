package practice.jianzhi;

import java.util.*;

/**
 * Created by liuzhugu on 2019/04/19.
 * 面试题45. 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        Map<Integer,List<String>> map = new TreeMap<>();
        for (int num : nums) {
            String str = num + "";
            int firstNum = str.charAt(0) - '0';
            List<String> list = map.get(firstNum);
            if (list == null) {
                list = new ArrayList<>();
                map.put(firstNum,list);
            }
            list.add(str);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (List<String> strings : map.values()) {
            strings.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o1 + o2).compareTo(o2 + o1);
                }
            });
            for (String str : strings) {
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }
}

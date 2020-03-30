package practice.leetcode;

import java.util.*;

/**
 * Created by liuzhugu on 2020/03/27。
 * 914. 卡牌分组
 *  给定一副牌，每张牌上都写着一个整数。
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 */
public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        Set<Integer> tmp = new HashSet<>();
        for (int value : map.values()) {
            tmp.add(value);
        }

        List<Integer> size = new ArrayList<>(tmp);
        int min = Integer.MAX_VALUE;
        for (int i : size) {
            if (i < min) {
                min = i;
            }
        }
        if (min == 1) return false;
        List<Integer> list = getPrimeMumber(min);
        for (int i : list) {
            int j = 0;
            for (;j < size.size();j ++) {
               if (size.get(j) % i != 0) {
                   break;
               }
            }
            if (j == size.size()) {
                return true;
            }
        }
        return false;
    }
    public List<Integer> getPrimeMumber(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            if (i != 1) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }
}

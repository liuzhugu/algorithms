package leetcode.editor.cn;

import java.util.*;

/**
 * Created by liuzhugu on 2019/03/24.
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，
 * 都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 */
public class CanReorderDoubled {
    public boolean canReorderDoubled(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        //统计
        for (int i = 0;i < A.length;i ++) {
           map.put(A[i],map.getOrDefault(A[i],0) + 1);
        }
        List<Integer> nums = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            int key = entry.getKey();
            if (key < 0) {
                key = key / 2;
            }else {
                key = key * 2;
            }
            //将相应部分减去该key的数量
            //比如2个2，3个4，1个8 其中2个2对应2个4  1个4对应1个8
            int n = map.getOrDefault(key,0);
            if (entry.getValue() > n) {
                return false;
            }else {
                map.put(key,n - entry.getValue());
            }
        }
        return true;
    }
}

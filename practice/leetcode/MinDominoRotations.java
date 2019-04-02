package practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuzhugu on 2019/04/02.
 * 1007. 行相等的最少多米诺旋转
 * 在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。
 * （一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 * 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。
 * 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。
 * 如果无法做到，返回 -1.
 */
public class MinDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Set<Integer>> AMap = new HashMap<>();
        Map<Integer,Set<Integer>> BMap = new HashMap<>();
        for (int i = 0;i < A.length;i ++) {
            Set<Integer> set = AMap.get(A[i]);
            if (set == null || set.isEmpty()) {
                set = new HashSet<>();
            }
            set.add(i);
            AMap.put(A[i],set);
        }
        for (int i = 0;i < B.length;i ++) {
            Set<Integer> set = BMap.get(B[i]);
            if (set == null || set.isEmpty()) {
                set = new HashSet<>();
            }
            set.add(i);
            BMap.put(B[i],set);
        }
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer,Set<Integer>> entry : AMap.entrySet()) {
            Set<Integer> ASet = entry.getValue();
            Set<Integer> BSet = BMap.get(entry.getKey());
            Set<Integer> allSet = new HashSet<>(ASet);
            if (BSet !=null && ! BSet.isEmpty()) {
                allSet.addAll(BSet);
            }
            if (allSet.size() == A.length) {
                if (BSet !=null && ! BSet.isEmpty()) {
                    int max = ASet.size() > BSet.size() ? ASet.size() : BSet.size();
                    result = (A.length - max) < result ? (A.length - max) : result;
                }else {
                    result = 0;
                }
            }
        }

        return  result == Integer.MAX_VALUE ? -1 : result;
    }
}

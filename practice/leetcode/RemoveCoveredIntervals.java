package practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int[] starts = new int[intervals.length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < intervals.length;i ++) {
            int[] interval = intervals[i];
            starts[i] = interval[0];
            //起点相同  结尾不同的  去结尾最大的
            if (interval[1] > map.getOrDefault(interval[0],0)){
                map.put(interval[0],interval[1]);
            }
        }
        //对起点排序
        Arrays.sort(starts);
        boolean[] isDel = new boolean[starts.length];
        for (int i = 0;i < starts.length;i ++) {
            //相同起点的区间只留一个
            if (i < starts.length - 1 && starts[i] == starts[i + 1]) {
                continue;
            }
            int start = starts[i];
            //该区间以被删除
            if (isDel[i] == true || map.get(start) == null)continue;
            int end = map.get(start);
            //找出位于范围内的区间
            for (int j = i + 1;j < starts.length;j ++) {
                if (starts[j] > end) break;
                if (isDel[j] == false && map.get(starts[j]) != null && map.get(starts[j]) <= end) {
                    map.remove(starts[j]);
                    isDel[j] = true;
                }
            }
        }
        return map.size();
    }
}

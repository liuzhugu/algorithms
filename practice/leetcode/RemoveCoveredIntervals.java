package practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhugu on 2019/12/27.
 * 1288. 删除被覆盖区间
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 */
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

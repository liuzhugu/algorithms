package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by liuzhugu on 2019/04/16.
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        // 先按照区间起始位置排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int start = Integer.MAX_VALUE,end = start;
        for (int i = 0;i < intervals.length;i ++) {
            int[] interval = intervals[i];
            if (start == Integer.MAX_VALUE) {
                start = interval[0];
                end = interval[1];
            } else {
                //不相交
                if (end < interval[0]) {
                    list.add(new int[]{start,end});
                    start = interval[0];
                    end = interval[1];
                } else {
                    end = Math.max(end,interval[1]);
                }
            }
        }
        list.add(new int[]{start,end});
        int[][] ans = new int[list.size()][2];
        if (! list.isEmpty()) {
            for (int i = 0;i < list.size();i ++) {
                ans[i] = list.get(i);
            }
        }
        return ans;
    }
}

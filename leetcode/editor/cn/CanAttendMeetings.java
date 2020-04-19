package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by liuzhugu on 2019/04/19.
 * 252. 会议室
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，
 * 请你判断一个人是否能够参加这里面的全部会议。
 */
public class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0;i < intervals.length - 1;i ++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    //手写冒泡
//    public boolean canAttendMeetings(int[][] intervals) {
//        if (intervals == null || intervals.length == 0) {
//            return true;
//        }
//        //冒泡排序
//        int m = intervals.length;
//        for (int i = 0;i < m;i ++) {
//            for (int j = m - 1;j > i;j --) {
//                if (intervals[j][0] < intervals[j - 1][0]) {
//                    int[] tmp = intervals[j];
//                    intervals[j] = intervals[j - 1];
//                    intervals[j - 1] = tmp;
//                }
//            }
//        }
//        for (int i = 0;i < m - 1;i ++) {
//            if (intervals[i][1] > intervals[i + 1][0]) {
//                return false;
//            }
//        }
//        return true;
//    }
}

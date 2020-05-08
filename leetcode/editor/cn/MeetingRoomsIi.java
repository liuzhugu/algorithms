//给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑
//充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。 
//
// 示例 1: 
//
// 输入: [[0, 30],[5, 10],[15, 20]]
//输出: 2 
//
// 示例 2: 
//
// 输入: [[7,10],[2,4]]
//输出: 1 
// Related Topics 堆 贪心算法 排序

package leetcode.editor.cn;

import java.util.*;

//Java：253:会议室 II 2020/05/08
public class MeetingRoomsIi{
    public static void main(String[] args) {
        Solution solution = new MeetingRoomsIi().new Solution();
        //TO TEST
        solution.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }
            Map<Integer, List<Integer>> range = new HashMap<>();
            int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
            Set<Integer> timeSet = new HashSet<>();
            for (int i = 0;i < intervals.length;i ++) {
                int[] interval = intervals[i];
                int start = interval[0],end = interval[1];
                if (range.get(start) == null) {
                    range.put(start,new ArrayList<>());
                }
                range.get(start).add(end);
                min = Math.min(min,start);
                max = Math.max(max,end);
                timeSet.add(start);
                timeSet.add(end);
            }
            List<Integer> timeList = new ArrayList<>(timeSet);
            timeList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            List<Integer> list = new ArrayList<>();
            int ans = 0;
            //遍历所有可能的时间点
            for (int m = 0;m < timeList.size();m ++) {
                Integer i = timeList.get(m);
                //找到以该时间为结束时间的会议 删除它
                if (list.contains(i)) {
                    list.remove(i);
                }
                //找到以该时间为起始时间的会议 加入会议室
                if (range.get(i) == null) {
                    continue;
                }
                List<Integer> meeting = range.get(i);
                //添加会议
                for (int j = 0;j < meeting.size();j ++) {
                    list.add(meeting.get(j));
                }
                //比较会议室数量
                ans = Math.max(ans,list.size());
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
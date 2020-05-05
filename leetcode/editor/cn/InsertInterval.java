//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
// Related Topics 排序 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Java：57:插入区间 2020/05/04
public class InsertInterval{
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
        //TO TEST
        solution.insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list = new ArrayList<>();
            if (intervals == null || intervals.length == 0) {
                return new int[][]{newInterval};
            }
            int m = intervals.length;
            if (newInterval != null && newInterval.length != 0) {
                list.add(newInterval);
            }
            for (int i = 0;i < m;i ++) {
                list.add(intervals[i]);
            }
            //排序
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            //区间合并
            int[] pre = list.get(0);
            List<int[]> ans = new ArrayList<>();
            for (int i = 1;i < list.size();i ++) {
                int[] tmp = list.get(i);
                if (pre[1] < tmp[0]) {
                    ans.add(pre);
                    pre = tmp;
                } else {
                    pre[0] = Math.min(pre[0],tmp[1]);
                    pre[1] = Math.max(pre[1],tmp[1]);
                }
            }
            ans.add(pre);
            int[][] result = new int[ans.size()][];
            for (int i = 0;i < ans.size();i ++) {
                result[i] = ans.get(i);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
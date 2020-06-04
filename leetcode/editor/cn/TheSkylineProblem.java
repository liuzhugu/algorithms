//城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由
//这些建筑物形成的天际线（图B）。 
//
// 
//
// 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0 
//≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的
//完美矩形。 
//
// 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。 
//
//
// 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点
//是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
// 
//
// 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
// 
//
// 说明: 
//
// 
// 任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。 
// 输入列表已经按左 x 坐标 Li 进行升序排列。 
// 输出列表必须按 x 位排序。 
// 输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三
//条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...] 
// 
// Related Topics 堆 树状数组 线段树 分治算法 Line Sweep

package leetcode.editor.cn;

import java.util.*;

//Java：218:天际线问题 2020/06/02
public class TheSkylineProblem{
    public static void main(String[] args) {
        Solution solution = new TheSkylineProblem().new Solution();
        //TO TEST
        //System.out.println(LeetCodeTest.strDeal("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]"));
        solution.getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            if (buildings == null || buildings.length == 0) {
                return new ArrayList<>();
            }
            return merge(buildings,0,buildings.length - 1);
        }
        private List<List<Integer>> merge(int[][] buildings,int start,int end) {
            List<List<Integer>> ans = new ArrayList<>();
            //只有一个
            if (start == end) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(buildings[start][0]);
                tmp.add(buildings[start][2]);
                ans.add(tmp);

                tmp = new ArrayList<>();
                tmp.add(buildings[start][1]);
                tmp.add(0);
                ans.add(tmp);
                return ans;
            }

            int mid = (start + end) / 2;
            List<List<Integer>> skyline1 = merge(buildings,start,mid);
            List<List<Integer>> skyline2 = merge(buildings,mid + 1,end);

            //合并
            int i = 0,j = 0,high1 = 0,high2 = 0;
            while (i < skyline1.size() || j < skyline2.size()) {
                long x1 = i == skyline1.size() ? Long.MAX_VALUE : skyline1.get(i).get(0);
                long x2 = j == skyline2.size() ? Long.MAX_VALUE : skyline2.get(j).get(0);
                long x = 0;
                if (x1 > x2) {
                    x = x2;
                    high2 = skyline2.get(j).get(1);
                    j ++;
                } else if (x1 < x2) {
                    x = x1;
                    high1 = skyline1.get(i).get(1);
                    i ++;
                } else {
                    high1 = skyline1.get(i).get(1);
                    high2 = skyline2.get(j).get(1);
                    x = x1;
                    i ++;
                    j ++;
                }
                //更新高度
                int high = Math.max(high1,high2);
                if (ans.isEmpty() || high != ans.get(ans.size() - 1).get(1)) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add((int)x);
                    tmp.add(high);
                    ans.add(tmp);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
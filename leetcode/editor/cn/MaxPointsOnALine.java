//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
// 
//
// 示例 2: 
//
// 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6 
// Related Topics 哈希表 数学

package leetcode.editor.cn;

import java.math.BigDecimal;
import java.util.*;

//Java：149:直线上最多的点数 2020/05/25
public class MaxPointsOnALine{
    public static void main(String[] args) {
        Solution solution = new MaxPointsOnALine().new Solution();
        //TO TEST
        solution.maxPoints(new int[][]{{3,1},{12,3},{3,1},{-6,-1}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //经过同一个点的直线  如归斜率相同  那么肯定是同一直线
        public int maxPoints(int[][] points) {
            if (points == null || points.length == 0) {
                return 0;
            }
            if (points.length == 1) {
                return 1;
            }
            int m = points.length;
            int ans = 0;
            for (int i = 0;i < m - 1;i ++) {
                Map<String,Integer> count = new HashMap<>();
                int repeat = 0;
                int tmpMax = 0;
                for (int j = i + 1; j < m; j++) {
                    int dx = points[j][0] - points[i][0];
                    int dy = points[j][1] - points[i][1];
                    //与起点是同一点 所以所有直线上的点都加1
                    if (dx == 0 && dy == 0) {
                        repeat ++;
                        continue;
                    }
                    //为了不使用除法  把两者都约到不能再约为止
                    //那么斜率相同的点 约过后的x和y都相同
                    int g = gcd(dy,dx);
                    //没有公约数
                    if (g != 0) {
                        dy = dy / g;
                        dx = dx / g;
                    }
                    String key = dy + "_" + dx;
                    //不算起点 最后才加上起点
                    count.put(key,count.getOrDefault(key,0) + 1);
                    tmpMax = Math.max(tmpMax,count.get(key));
                }
                //加上起点
                ans = Math.max(ans,repeat + tmpMax + 1);

            }
            return ans;
        }
        private int gcd (int x,int y) {
            if (y == 0) {
                return x;
            } else {
                return gcd(y,x % y);
            }
        }

        //leetcode不支持BigDecimal  但double计算不精准 所以废弃
//        public int maxPoints(int[][] points) {
//            if (points == null || points.length == 0) {
//                return 0;
//            }
//            if (points.length == 1) {
//                return 1;
//            }
//            //所有可能的b
//            Set<BigDecimal> bSet = new HashSet<>();
//            //每个b对应的k
//            Map<BigDecimal, Set<BigDecimal>> kMap = new HashMap<>();
//
//            //平行于X轴的直线有多少个节点
//            Map<Integer, Integer> xMap = new HashMap<>();
//            //平行于y轴的直线有多少个节点
//            Map<Integer, Integer> yMap = new HashMap<>();
//            //斜线有多少个节点 key为 k_b
//            Map<String, Integer> slashMap = new HashMap<>();
//            int m = points.length;
//            //两两节点确定直线
//            for (int i = 0;i < m - 1;i ++) {
//                for (int j = i + 1;j < m;j ++) {
//                    //平行于y轴
//                    if (points[i][0] == points[j][0]) {
//                        //初始化
//                        yMap.put(points[i][0],0);
//                        continue;
//                    }
//                    //平行于x轴
//                    if (points[i][1] == points[j][1]) {
//                        //初始化
//                        xMap.put(points[i][1],0);
//                        continue;
//                    }
//                    //斜线
//                    BigDecimal k = new BigDecimal(points[j][1] - points[i][1]).divide(new BigDecimal(points[j][0] - points[i][0]),2, BigDecimal.ROUND_HALF_UP);
//                    BigDecimal b = new BigDecimal(points[j][1]).subtract(new BigDecimal(points[j][0]).multiply(k));
//                    bSet.add(b);
//                    if (! kMap.containsKey(b)) {
//                        kMap.put(b,new HashSet<>());
//                    }
//                    kMap.get(b).add(k);
//                    String key = k + "_" + b;
//                    //初始化
//                    slashMap.put(key,0);
//                }
//            }
//
//            for (int i = 0;i < m;i ++) {
//                int[] point = points[i];
//                int x = point[0],y = point[1];
//                if (xMap.containsKey(y)) {
//                    xMap.put(y,xMap.get(y) + 1);
//                }
//                if (yMap.containsKey(x)) {
//                    yMap.put(x,yMap.get(x) + 1);
//                }
//                //此时b = y  k可以为任意值
//                if (x == 0) {
//                    BigDecimal b = new BigDecimal(y);
//                    Set<BigDecimal> kSet = kMap.get(b);
//                    if (kSet != null) {
//                        for (BigDecimal k : kSet) {
//                            String key = k + "_" + b;
//                            slashMap.put(key,slashMap.get(key) + 1);
//                        }
//                    }
//                    continue;
//                }
//                for (BigDecimal b : bSet) {
//                    BigDecimal k = new BigDecimal(y).subtract(b).divide(new BigDecimal(x),2, BigDecimal.ROUND_HALF_UP);
//                    Set<BigDecimal> set = kMap.get(b);
//                    if (set.contains(k)) {
//                        String key = k.toString() + "_" + b;
//                        if (slashMap.containsKey(key)) {
//                            slashMap.put(key,slashMap.get(key) + 1);
//                        }
//                    }
//                }
//            }
//            int ans = 0;
//            for (int count : xMap.values()) {
//                ans = Math.max(ans,count);
//            }
//            for (int count : yMap.values()) {
//                ans = Math.max(ans,count);
//            }
//            for (int count : slashMap.values()) {
//                ans = Math.max(ans,count);
//            }
//            return ans;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
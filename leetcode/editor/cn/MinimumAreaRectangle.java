//给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。 
//
// 如果没有任何矩形，就返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,1],[1,3],[3,1],[3,3],[2,2]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 500 
// 0 <= points[i][0] <= 40000 
// 0 <= points[i][1] <= 40000 
// 所有的点都是不同的。 
// 
// Related Topics 哈希表 
// 👍 61 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：939:最小面积矩形
public class MinimumAreaRectangle{
    public static void main(String[] args) {
        Solution solution = new MinimumAreaRectangle().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //斜对角线
        public int minAreaRect(int[][] points) {

            int ans = Integer.MAX_VALUE;
//            for (int i = 0; i < points.length; ++i)
//                for (int j = i + 1; j < points.length; ++j) {
//                    if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
//                        if (pointSet.contains(40001 * points[i][0] + points[j][1]) &&
//                                pointSet.contains(40001 * points[j][0] + points[i][1])) {
//                            ans = Math.min(ans, Math.abs(points[j][0] - points[i][0]) *
//                                    Math.abs(points[j][1] - points[i][1]));
//                        }
//                    }
//                }

            Set<Integer> pointSet = new HashSet<>();
            //先保存所有节点
            for (int[] point : points) {
                //将二维数组合并成一维数组  并且合并之后只有完全相同才会相同
                pointSet.add(40001 * point[0] + point[1]);
            }

            for (int i = 0;i < points.length;i ++) {
                for (int j = i + 1;j < points.length;j ++) {
//                    if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
//                        if (pointSet.contains(40001 * points[i][0] + points[j][1]) &&
//                                pointSet.contains(40001 * points[j][0] + points[i][1])) {
//                            ans = Math.min(ans, Math.abs(points[j][0] - points[i][0]) *
//                                    Math.abs(points[j][1] - points[i][1]));
//                        }
//                    }
//                    //不在同一行或同一列上  这样才能是斜对角
                    if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {                        //判断另外两个节点是否存在
                        if (pointSet.contains(40001 * points[i][0] + points[j][1]) &&
                                pointSet.contains(40001 * points[j][0] + points[i][1])) {
                            ans = Math.min(ans,Math.abs(points[j][1] - points[i][1])
                                    * Math.abs(points[j][0] - points[i][0]));
                        }
                    }
                }
            }
            return ans < Integer.MAX_VALUE ? ans : 0;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法

package leetcode.editor.cn;

import java.util.*;

//Java：406:根据身高重建队列 2020/05/14
public class QueueReconstructionByHeight{
    public static void main(String[] args) {
        Solution solution = new QueueReconstructionByHeight().new Solution();
        //TO TEST
        System.out.println(LeetCodeTest.strDeal("[[9,0],[7,0],[1,9],[3,0],[2,7],[5,3],[6,0],[3,4],[6,2],[5,2]]"));
        solution.reconstructQueue(new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            if (people == null || people.length == 0) {
                return new int[][]{};
            }
            int m = people.length;
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                   if (o1[0] == o2[0]) {
                       //身高相同  按次序从小到大拍
                       return o1[1] - o2[1];
                   } else {
                       //身高不同  按身高从大到小拍
                       return o2[0] - o1[0];
                   }
                }
            });
            List<int[]> res = new LinkedList<>();
            for (int i = 0;i < m;i ++) {
                int[] num = people[i];
                res.add(num[1],num);
            }
            int[][] ans = new int[m][2];
            for (int i = 0;i < m;i ++) {
                ans[i] = res.get(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
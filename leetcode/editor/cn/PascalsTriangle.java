//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：118:杨辉三角 2020/05/18
public class PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) {
                return null;
            }
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            list.add(new ArrayList<>(tmp));
            if (numRows == 1) {
                return list;
            }
            tmp.add(1);
            list.add(new ArrayList<>(tmp));
            if (numRows == 2) {
                return list;
            }
            for (int i = 3;i <= numRows;i ++) {
                tmp = new ArrayList<>();
                tmp.add(1);
                for (int j = 1;j < i - 1;j ++) {
                    tmp.add(list.get(i - 2).get(j - 1) + list.get(i - 2).get(j));
                }
                tmp.add(1);
                list.add(tmp);
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
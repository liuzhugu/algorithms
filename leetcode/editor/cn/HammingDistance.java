//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算

package leetcode.editor.cn;
//Java：461:汉明距离 2020/05/17
public class HammingDistance{
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            //令x > y
            if (x < y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            int count = 0;
            while (x > 0 && y > 0) {
                if ((x & 1) != (y & 1)) {
                    count ++;
                }
                x = x >> 1;
                y = y >> 1;
            }
            while (x > 0) {
                if ((x & 1) == 1) {
                    count ++;
                }
                x = x >> 1;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
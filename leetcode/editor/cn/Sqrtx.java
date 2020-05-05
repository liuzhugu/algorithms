//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找

package leetcode.editor.cn;
//Java：69:x 的平方根 2020/05/05
public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        //TO TEST
        solution.mySqrt(2147395599);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x < 2) return x;
            //二分查找比顺序查找要好
            int left = 2,right = x / 2,index;
            while (left <= right) {
                //防止越界
                index = left + (right - left) / 2;
                //右边必须声明为long  否则溢出了  会被截断
                long num = (long)index * index;
                if (num == x) {
                    return index;
                }
                if (num < x) {
                    left = index + 1;
                } else {
                    right = index - 1;
                }
            }
            return right;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
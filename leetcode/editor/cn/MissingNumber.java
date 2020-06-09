//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 
//
// 示例 1: 
//
// 输入: [3,0,1]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 
//
// 说明: 
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学

package leetcode.editor.cn;
//Java：268:缺失数字 2020/06/06
public class MissingNumber{
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //自己异或自己为0   任何数与0异或为它自己
        public int missingNumber(int[] nums) {
            int missing = nums.length;
            //与[0,n]异或  然后在于数组的数异或  如果数组中出现的  那么一共出现两次  结果为0
            //在数组中没出现的话 那么只出现一次   结果为自己   总异或结果为只出现一次的数
            for (int i = 0;i < nums.length;i ++) {
                missing = missing ^ (i ^ nums[i]);
            }
            return missing;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
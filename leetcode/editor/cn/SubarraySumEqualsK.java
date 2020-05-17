//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：560:和为K的子数组 前缀和 2020/05/14
public class SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        //TO TEST
        solution.subarraySum(new int[]{-1,-1,1},0);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //前缀和
        public int subarraySum(int[] nums, int k) {
            int m = nums.length;
            Map<Integer,Integer> map = new HashMap<>();
            int pre = 0,count = 0;
            //直接等于k的数的哨兵
            map.put(0,1);
            for (int i = 0;i < m;i ++) {
                pre = pre + nums[i];
                if (map.containsKey(pre - k)) {
                    count = map.get(pre - k) + count;
                }
                map.put(pre,map.getOrDefault(pre,0) + 1);
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
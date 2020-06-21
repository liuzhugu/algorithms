//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 示例: 
//
// 输入: [5,2,6,1]
//输出: [2,1,1,0] 
//解释:
//5 的右侧有 2 个更小的元素 (2 和 1).
//2 的右侧仅有 1 个更小的元素 (1).
//6 的右侧有 1 个更小的元素 (1).
//1 的右侧有 0 个更小的元素.
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：315:计算右侧小于当前元素的个数 2020/06/12
public class CountOfSmallerNumbersAfterSelf{
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        //TO TEST
        solution.countSmaller(new int[]{5,2,6,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        //临时空间来转移index
        int[] temp;
        //保存该位置的数在原数组的位置
        int[] indexes;
        //原数组每个数对应的答案
        int[] counter;

        //因为nums数组的值一直不移动  所以取值的时候要通过index数组加一次转换
        public List<Integer> countSmaller(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            int n = nums.length;
            temp = new int[n];
            indexes = new int[n];
            counter = new int[n];
            //初始化indexes
            for (int i = 0;i < n;i ++) {
                indexes[i] = i;
            }
            merge(nums,0,n - 1);
            List<Integer> res = new ArrayList<>();
            for (int i = 0;i < n;i ++) {
                res.add(counter[i]);
            }
            return res;
        }
        private void merge(int[] nums,int l,int r) {
            if (l == r) {
                return;
            }
            int mid = (l + r) / 2;
            merge(nums,l,mid);
            merge(nums,mid + 1,r);
            //如果有序  那么不用统计每个数的右边比它小的由几个数  因为都比它大
            if (nums[indexes[mid]] > nums[indexes[mid + 1]]) {
                count(nums,l,mid,r);
            }
        }

        //对于左边每个数  在它右边比它小的数  是在它出列前右边比它先出列的数
        //至于右边  其结果已经确定  不用处理
        private void count(int[] nums,int l,int mid,int r) {
            //先保存该位置在最初始位置的index   给它找到新位置后  把index移动过去
            for (int i = l; i <= r; i++) {
                temp[i] = indexes[i];
            }
            int i = l;
            int j = mid + 1;
            //k为个数
            for (int k = l;k <= r;k ++) {
                //左边出完了
                if (i > mid) {
                    indexes[k] = temp[j];
                    j++;
                }
                else if (j > r) {
                    indexes[k] = temp[i];
                    i++;
                    // 此时 j 用完了，[7,8,9 | 1,2,3]
                    // 之前的数就和后面的区间长度构成逆序
                    counter[indexes[k]] += (r - mid);
                }
                //选小的出列  因为index数组的值变了  所以取temp
                else if (nums[temp[i]] <= nums[temp[j]]) {
                    indexes[k] = temp[i];
                    //加上右边已经出列的个数
                    i ++;
                    counter[indexes[k]] +=  (j - mid - 1);
                }
                else {
                    indexes[k] = temp[j];
                    j ++;
                }
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

package leetcode.editor.cn;
//Java：88:合并两个有序数组
public class MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        //TO TEST
        solution.merge(new int[]{4,0,0,0,0,0},1,new int[]{1,2,3,4,5},5);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //腾出位置
            if (m > 0) {
                for (int i = m - 1;i >= 0;i --) {
                    nums1[i + n] = nums1[i];
                }
            }
            int first = n,second = 0,index = 0;
            m = m + n;
            while (first < m && second < n) {
                if (nums1[first] > nums2[second]) {
                    nums1[index] = nums2[second];
                    index ++;
                    second ++;
                } else {
                    nums1[index] = nums1[first];
                    index ++;
                    first ++;
                }
            }
            if (first < m) {
                while (first < m) {
                    nums1[index] = nums1[first];
                    index ++;
                    first ++;
                }
            }
            if (second < n) {
                while (second < n) {
                    nums1[index] = nums2[second];
                    index ++;
                    second ++;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
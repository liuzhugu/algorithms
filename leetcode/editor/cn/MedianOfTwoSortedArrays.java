//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

package leetcode.editor.cn;
//Java：4:寻找两个有序数组的中位数 2020/04/24
public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        //TO TEST
        System.out.println(solution.findMedianSortedArrays(new int[]{1,2},new int[]{4,5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int i = 0,j = 0,m = A.length,n = B.length;
            int count = (m + n + 1) / 2;
            //先找出前count个数
            while (i < m && j < n && count > 0) {
                if (A[i] < B[j]) {
                    i ++;
                } else {
                    j ++;
                }
                count --;
            }
            if (count > 0) {
                if (i == m) {
                    while (count > 0) {
                        j ++;
                        count --;
                    }
                } else {
                    while (count > 0) {
                        i ++;
                        count --;
                    }
                }
            }
            int maxLeft = 0;
            //中位数在B
            if (i == 0) {
                maxLeft = B[j-1];
            }
            //中位数在A
            else if (j == 0) {
                maxLeft = A[i-1];
            }
            else {
                maxLeft = Math.max(A[i-1], B[j-1]);
            }
            //因为此时maxLeft为第(m + n + 1) / 2个数
            if ( (m + n) % 2 == 1 ) {
                return maxLeft;
            }

            int minRight = 0;
            if (i == m) {
                minRight = B[j];
            }
            else if (j == n) {
                minRight = A[i];
            }
            else {
                minRight = Math.min(B[j], A[i]);
            }

            return (maxLeft + minRight) / 2.0;
        }

//        public double findMedianSortedArrays(int[] A, int[] B) {
//            int first = 0,second = 0,m = A.length,n = B.length;
//            int count = (m + n + 1) / 2;
//            //令A更短
//            if (m > n) {
//                int[] temp = A;
//                A = B;
//                B = temp;
//                int tmp = m;
//                m = n;
//                n = tmp;
//            }
//            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
//            //变种的滑动窗口
//            while (iMin <= iMax) {
//                //在A中的位置  一开始为一半
//                int i = (iMin + iMax) / 2;
//                //在B中的位置  补充i中不足的
//                int j = halfLen - i;
//                //先选够足够数量 此时的i和j还不一定满足条件  因此要调整
//
//                //如果B[j-1] > A[i]  那么B[j]肯定大于A[i] 而A[i+1]也大于A[i]
//                //但B[j-1] B[j]  A[i+1]这三者大小待确定  所以先让[j-1]和A[i+1]比较
//                //如果A中多一个 那么B中必须少一个
//                if (i < iMax && B[j-1] > A[i]){
//                    iMin = i + 1; // i is too small
//                }
//                //同理可得
//                else if (i > iMin && A[i-1] > B[j]) {
//                    iMax = i - 1; // i is too big
//                }
//                else {
//                    //此时A[i - 1] < A[i] 和 B[j]
//                    //   B[j - 1] < B[j] 和 A[i]
//                    int maxLeft = 0;
//                    //中位数在B
//                    if (i == 0) {
//                        maxLeft = B[j-1];
//                    }
//                    //中位数在A
//                    else if (j == 0) {
//                        maxLeft = A[i-1];
//                    }
//                    else {
//                        maxLeft = Math.max(A[i-1], B[j-1]);
//                    }
//                    if ( (m + n) % 2 == 1 ) {
//                        return maxLeft;
//                    }
//
//                    int minRight = 0;
//                    if (i == m) {
//                        minRight = B[j];
//                    }
//                    else if (j == n) {
//                        minRight = A[i];
//                    }
//                    else {
//                        minRight = Math.min(B[j], A[i]);
//                    }
//
//                    return (maxLeft + minRight) / 2.0;
//                }
//            }
//            return 0.0;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
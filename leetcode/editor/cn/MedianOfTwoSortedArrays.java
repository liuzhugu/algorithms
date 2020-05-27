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
//Java：4:寻找两个有序数组的中位数 2020/05/24
public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        //TO TEST
        System.out.println(solution.findMedianSortedArrays(new int[]{1,2},new int[]{4,5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(log(m + n))  相比于第二种解法每次只排除一个  该方法每次最多去掉K / 2个
        public double findMedianSortedArrays(int[] A, int[] B) {
            int m = A.length,n = B.length;
            //如果总长度是奇数  那么left == right  否则 right ==  left + 1
            int left = (m + n + 1) / 2,right = (m + n + 2) / 2;
            return (getKth(A,0,m - 1,B,0,n - 1,left) +
                    getKth(A,0,m - 1,B,0,n - 1,right)) / 2.0;
        }
        //尾递归
        private int getKth(int[] num1,int start1,int end1,int[] num2,int start2,int end2,int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            //令len1更小  这样 如果数组空了 那么肯定是len1
            if (len1 > len2) {
                return getKth(num2,start2,end2,num1,start1,end1,k);
            }

            //递归终止条件
            if (len1 == 0) {
                return num2[start2 + k - 1];
            }
            if (k == 1) {
                return Math.min(num1[start1],num2[start2]);
            }

            //递归
            //找k / 2  并且防止越界
            int i = start1 + Math.min(len1,k / 2) - 1;
            int j = start2 + Math.min(len2,k / 2) - 1;
            if (num1[i] > num2[j]) {
                //num2[j]及其之前的全去掉
                return getKth(num1,start1,end1,num2,j + 1,end2,k - (j - start2 + 1));
            } else {
                //num1[i]及其之前的全去掉
                return getKth(num1,i + 1,end1,num2,start2,end2,k - (i - start1 + 1));
            }
        }

        // O(m + n)
//        public double findMedianSortedArrays(int[] A, int[] B) {
//            int m = A.length,n = B.length;
//            int len = m + n;
//            int pre = -1,next = -1;
//            int astart = 0,bstart = 0;
//            //遍历一半   总长度是单数  只看right  是偶数   看left和right
//            for (int i = 0;i <= len / 2;i ++) {
//                pre = next;
//                //要么a步进  要么b步进
//                if (astart < m  && (bstart >= n || A[astart] < B[bstart])) {
//                    //B到了结尾  或者 a比b对应位置的数更小
//                    next = A[astart ++];
//                } else {
//                    next = B[bstart ++];
//                }
//            }
//            if (len % 2 == 0) {
//               return (pre + next) / 2.0;
//            } else {
//                return next;
//            }
//        }

        //O(log(m + n))
//        public double findMedianSortedArrays(int[] A, int[] B) {
//            int first = 0,second = 0,m = A.length,n = B.length;
//            int count = (m + n + 1) / 2;
//            //令A更短
//            if (m > n) {
//                int[] temp = A;
//                A = B;
//                B = temp;
//                m = A.length;
//                n = B.length;
//            }
//            int iLeft = 0, iRight = m, halfLen = (m + n + 1) / 2;
//            //变种的滑动窗口
//            while (iLeft <= iRight) {
//                //在A中的位置  一开始为一半
//                int i = (iLeft + iRight) / 2;
//                //在B中的位置  补充i中不足的
//                int j = halfLen - i;
//                //先选够足够数量 此时的i和j还不一定满足条件  因此要调整
//
//                //如果B[j-1] > A[i]  那么B[j]肯定大于A[i] 而A[i+1]也大于A[i]
//                //但B[j-1] B[j]  A[i+1]这三者大小待确定  所以先让[j-1]和A[i+1]比较
//                //如果A中多一个 那么B中必须少一个
//                if (i < iRight && B[j-1] > A[i]){
//                    iLeft = i + 1; // i is too small
//                }
//                //同理可得
//                else if (i > iLeft && A[i-1] > B[j]) {
//                    iRight = i - 1; // i is too big
//                }
//                else {
//                    //此时A[i - 1] < A[i] 和 B[j]
//                    //   B[j - 1] < B[j] 和 A[i]
//                    int maxLeft = 0;
//
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
//（这是一个 交互式问题 ） 
//
// 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 
//值。 
//
// 如果不存在这样的下标 index，就请返回 -1。 
//
// 
//
// 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件： 
//
// 首先，A.length >= 3 
//
// 其次，在 0 < i < A.length - 1 条件下，存在 i 使得： 
//
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[A.length - 1] 
// 
//
// 
//
// 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据： 
//
// 
// MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始） 
// MountainArray.length() - 会返回该数组的长度 
// 
//
// 
//
// 注意： 
//
// 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。 
//
// 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请
//注意这 不是一个正确答案。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：array = [1,2,3,4,5,3,1], target = 3
//输出：2
//解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。 
//
// 示例 2： 
//
// 输入：array = [0,1,2,4,2,1], target = 3
//输出：-1
//解释：3 在数组中没有出现，返回 -1。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= mountain_arr.length() <= 10000 
// 0 <= target <= 10^9 
// 0 <= mountain_arr.get(index) <= 10^9 
// 
// Related Topics 二分查找

package leetcode.editor.cn;
//Java：1095:山脉数组中查找目标值
class MountainArray {
    private int[] arr;
    private int count = 0;
    public MountainArray(int[] arr) {
        this.arr = arr;
    }
    public int get(int index) {
        if (count == 100) {
            System.out.println("error");
        }
        count ++;
        return arr[index];
    }
    public int length() {
        return arr.length;
    }
}

public class FindInMountainArray{
    public static void main(String[] args) {
        Solution solution = new FindInMountainArray().new Solution();
        //TO TEST
        MountainArray mountainArray =  new MountainArray(new int[]{3,5,3,2,0});
        System.out.println(solution.findInMountainArray(5,mountainArray));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            return findInMountainArray(target,mountainArr,0,mountainArr.length() - 1);
        }
        public int findInMountainArray(int target, MountainArray mountainArr,int start,int end) {
            while (start <= end) {
                int mid = (start + end) / 2;
                int midNum = mountainArr.get(mid);
                if (mid - 1 >= 0 && mid + 1 < mountainArr.length()) {
                    if (target > midNum) {
                        int pre = mountainArr.get(mid - 1);
                        int next = mountainArr.get(mid + 1);
                        //mid是顶峰
                        if (pre < midNum && next < midNum) {
                            return -1;
                        }
                        //mid在左半峰 那么想要的结果在右边
                        if (pre < midNum && midNum < next) {
                            start = mid + 1;
                        }
                        if (pre > midNum && midNum > next) {
                            end = mid - 1;
                            //左边不可能了 可以判断该点了
                            if (midNum == target) {
                                return mid;
                            }
                        }
                    } else {
                        //target在山的两边
                        int pre = mountainArr.get(mid - 1);
                        int next = mountainArr.get(mid + 1);
                        int ans;
                        //mid是顶峰  两边找
                        if (pre < midNum && next < midNum) {
                            //左边
                            ans = find(mountainArr,target,start, mid - 1,true);
                            if (ans != -1) {
                                return ans;
                            }
                            if (midNum == target) {
                                return mid;
                            }
                            //左边找不到就在右边找
                            ans = find(mountainArr,target,mid + 1, end,false);
                            if (ans != -1) {
                                return ans;
                            }
                            //都找不到
                            return - 1;
                        }
                        //mid在左边山峰  其左边单调递增  右边是山峰
                        if (pre < midNum && midNum < next) {
                            //单调递增
                            ans = find(mountainArr,target,start, mid - 1,true);
                            if (ans != -1) {
                                return ans;
                            }
                            //左边不可能了 可以判断该点了
                            if (midNum == target) {
                                return mid;
                            }
                            //右边是山峰
                            ans = findInMountainArray(target,mountainArr,mid + 1, end);
                            if (ans != -1) {
                                return ans;
                            }
                            //都找不到
                            return - 1;
                        }
                        //mid在右边山峰  其右边单调递减  左边是山峰
                        if (pre > midNum && midNum > next) {
                            //左边是山峰
                            ans = findInMountainArray(target,mountainArr,start, mid - 1);
                            if (ans != -1) {
                                return ans;
                            }
                            //其右边单调递减
                            ans = find(mountainArr,target,mid + 1, end,false);
                            if (ans != -1) {
                                return ans;
                            }
                            //都找不到
                            return - 1;
                        }
                    }
                }
                //mid是起点或终点
                else {
                    int ans;
                    //只有右边
                    if (mid - 1 < 0) {
                        //左边不可能了 可以判断该点了
                        if (midNum == target) {
                            return mid;
                        }
                        ans = findInMountainArray(target,mountainArr,mid + 1, end);
                        if (ans != -1) {
                            return ans;
                        }
                    }
                    //只有左边
                    else if (mid + 1 == mountainArr.length()) {
                        ans = findInMountainArray(target,mountainArr,start, mid - 1);
                        if (ans != -1) {
                            return ans;
                        }
                    }
                    return -1;
                }
            }
            return - 1;
        }
        //单调找
        private int find(MountainArray mountainArr,int target,int start,int end,boolean increment) {
            //单调递增
            int mid = (start + end) / 2;
            int midNum = mountainArr.get(mid);
            if (midNum == target) {
                return mid;
            }
            if (increment) {
                while (start < end) {
                    if (midNum > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                    mid = (start + end) / 2;
                    midNum = mountainArr.get(mid);
                    if (midNum == target) {
                        return mid;
                    }
                }
            }
            //单调递减
            else {
                while (start < end) {
                    if (midNum < target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                    mid = (start + end) / 2;
                    midNum = mountainArr.get(mid);
                    if (midNum == target) {
                        return mid;
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/07.
 * 面试题53 - I. 在排序数组中查找数字 I
 *  统计一个数字在排序数组中出现的次数。
 */
public class Search {
    public int search(int[] nums, int target) {
        //二分查找法
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0,end = nums.length - 1;
        int count = 0,index = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        if (nums[start] == target) {
            index = start;
        }
        if (index != -1) {
            count ++;
            //向右查找
            for (int i = index + 1;i < nums.length;i ++) {
                if (nums[i] == target) {
                    count ++;
                }else {
                    break;
                }
            }
            //向左查找
            for (int i = index - 1;i >= 0;i --) {
                if (nums[i] == target) {
                    count ++;
                }else {
                    break;
                }
            }
        }
        return count;
    }
}

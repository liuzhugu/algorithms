package practice.leetcode;

/**
 * Created by liuzhugu on 2020/01/06.
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1]。
 */
public class SearchRange {
    //二分查找
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums == null || nums.length == 0)return result;
        int left = 0,right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                left = right = mid;
            }
        }
        if (nums[left] != target) {
            return result;
        }else {
            while (left > 0 && nums[left] == nums[left - 1]) left --;
            while (right < nums.length - 1 && nums[right] == nums[right + 1]) right ++;
            result[0] = left;
            result[1] = right;
            return result;
        }
    }
}

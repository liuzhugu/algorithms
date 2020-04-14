package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/04/14.
 * 面试题57. 和为s的两个数字
 *  输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 *  如果有多对数字的和等于s，则输出任意一对即可。
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int left = 0,right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left ++;
            } else if (sum > target) {
                right --;
            } else {
                ans = new int[]{nums[left],nums[right]};
            }
        }
        return ans;
    }

//    public int[] twoSum(int[] nums, int target) {
//        int[] ans = new int[2];
//        if (nums == null || nums.length == 0) {
//            return ans;
//        }
//        int left = 0,right = nums.length - 1;
//        //找到小于target中最大的数
//        while (right > 0 && nums[right] >= target) {
//            right --;
//        }
//        for (int i = right;i > 0;i --) {
//            for (int j = 0;j < right;j ++) {
//                if (nums[i] + nums[j] == target) {
//                    ans[0] = nums[j];
//                    ans[1] = nums[i];
//                    return ans;
//                }
//            }
//        }
//        return ans;
//    }
}

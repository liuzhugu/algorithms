package practice.leetcode;

public class Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }

        int result = -1;
        int left = 0, right = nums.length - 1;
        if (nums[0] > target) {
            while (left < right) {
                int middle = (left + right) / 2;
                if (nums[middle] > target) {
                    if (nums[middle] >= nums[0]) {
                        left = middle + 1;
                    }else {
                        right = middle - 1;
                    }
                }else if (nums[middle] < target){
                   left = middle + 1;
                }else {
                    return middle;
                }
            }
        }else if (nums[0] < target){
            while (left < right) {
                int middle = (left + right) / 2;
                if (nums[middle] < target) {
                    if (nums[middle] >= nums[0]) {
                        left = middle + 1;
                    }else {
                        right = middle -1;
                    }
                }else if (nums[middle] > target){
                    right = middle - 1;
                }else {
                    return middle;
                }
            }
        }else {
            return 0;
        }
        if (nums[left] == target) {
            return left;
        }
        return result;
    }
}

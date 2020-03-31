package practice.jianzhi;

/**
 * 快排
 * */
public class QuickSort {
    public int[] quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSort(nums,0,nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums,int start,int end) {
        if (start >= end) return;
        int index = getIndex(nums,start,end);
        quickSort(nums,start,index - 1);
        quickSort(nums,index + 1,end);
    }
    private int getIndex(int[] nums,int start,int end) {
        if (start >= end) return start;
        int goal = nums[start];
        int left = start,right = end;
        while (left < right) {
            while (left < right && nums[right] > goal) {
                right --;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < goal) {
                left ++;
            }
            nums[right] = nums[left];
        }
        nums[left] = goal;
        return left;
    }
}
